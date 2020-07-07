package org.yeyz.fourm.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.yeyz.fourm.dto.AccessTokenDTO;
import org.yeyz.fourm.dto.GitHubUser;
import org.yeyz.fourm.method.SendMethod;
import org.yeyz.fourm.model.UserOracle;
import org.yeyz.fourm.service.IUserOracleService;

import net.sf.json.JSONObject;





@Controller
public class AuthController {
	
	@Autowired
	SendMethod send;
	
	@Autowired
	AccessTokenDTO accesstokendto;
	
	@Autowired
	IUserOracleService service;
	
	@GetMapping("/callback")
	public String callback(
			@RequestParam("code") String code,
			@RequestParam("state") String state,
			HttpServletRequest request,
			HttpServletResponse response
			) {
		synchronized (this) {
			accesstokendto.setCode(code);
			accesstokendto.setState(state);
			
			String url = "https://github.com/login/oauth/access_token";
			JSONObject json = JSONObject.fromObject(accesstokendto);
			
			String result = send.OkPost(url,json.toString());
			System.out.println(result);
			
			//处理 access_token
			String [] infos = result.split("&");
			String[] info = infos[0].split("=");
			String access_token = info[1];
			
			System.out.println("access_token : "  + access_token);
			
			//获取用户信息
			GitHubUser gitHubUser = send.getUser(access_token);
			System.out.println(gitHubUser);
			System.out.println("登录验证工作");
			//处理token的flag
			boolean flag = false;
			
			//登录逻辑处理
			if( gitHubUser != null ) {
				
				/*
				 *  cookies处理
				 *  user为 获取用户信息 
				 *  GitHubUser user = send.getUser(access_token);
				 */
				
				/*
				 * 处理时间
				 */	
				SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
				//创建的当前时间
				Long currentTimeCreate = System.currentTimeMillis();
				String date = sdf.format(new Date());
				
				String name = gitHubUser.getName();
				Long id = gitHubUser.getId().longValue();
				String bio = gitHubUser.getBio();
				String token = UUID.randomUUID().toString();
				String gtm_create = date;
				//关于 gtm_modified的处理目前有疑问 ?
				Long modifiedTime = (System.currentTimeMillis() - currentTimeCreate)/1000/3600;
				String gtm_modified = modifiedTime.toString();
				
				//获取头像信息
				String avatar_url = gitHubUser.getAvatar_url();
				
				UserOracle user = new UserOracle(name, id, bio, token, gtm_create, gtm_modified,avatar_url);
				List<UserOracle> userOracles = service.queryUserOracle(); 			
				//先查询数据库是否有数据再执行插入操作 查询数据库的所有id
				List<Long> ids = new ArrayList<Long>();
				for(UserOracle us : userOracles) {
					ids.add(us.getId());
				}
				//不存在则插入数据库
				if( !ids.contains(id) ) {
					//插入数据库
					service.addUserOracle(user);
					flag = true;
				}else {
					System.out.println("已存在");
					/*
					 * id已存在,从数据库获取
					 */
					for(UserOracle us : userOracles) {
						if( id == us.getId() ) {
							token = us.getToken();
							Cookie cookie = new Cookie("token", token);
							cookie.setMaxAge(60 * 60 * 24 * 30 * 6);
							response.addCookie(cookie);
							break;
						}
					}
					
					HttpSession session = request.getSession();
					session.setAttribute("user",user);
					
					
					
				}
				/*
				 * 数据库有数据 浏览器没 cookie token
				 * 由于UUID是不断变化的 ,如果不进行处理 IndexController会由于token变化拿不到值
				 */
				//将cookie放入浏览器
				if( flag == true ) {
					response.addCookie(new Cookie("token",token));
					return "redirect:/";
				}
				
				
				//return "redirect:http://yeyz.free.idcfengye.com";
				
			}else {
				//登录失败,重新登录
				return "redirect:/";
				//return "redirect:http://yeyz.free.idcfengye.com";
			}

			//return "index";
			
			//localhost:8080/callback
			
		}
		return "index";
		}
		
	
	/*
	 * 退出登录
	 * 移除 token 和服务端的session
	 */
	
	@GetMapping("/logOut")
	public String logOut(HttpServletRequest request,HttpServletResponse response) {
		
		System.out.println("退出登录");
		/*
		 * 清除session
		 */
		request.getSession().removeAttribute("user");
		
		/*
		 * 清除cookie
		 * 将同名的 cookie 设为 null
		 */
		Cookie cookie = new Cookie("token",null);
		//马上清除
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		
		return "redirect:/";
	}
	
	
	
}
