package org.yeyz.fourm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.yeyz.fourm.dto.AccessTokenDTO;
import org.yeyz.fourm.dto.GitHubUser;
import org.yeyz.fourm.method.SendMethod;

import net.sf.json.JSONObject;





@Controller
//
public class AuthController {
	
	@Autowired
	SendMethod send;
	
	@Autowired
	AccessTokenDTO accesstokendto;
	
	
	
	@GetMapping("/callback")
	public String callback(
			@RequestParam("code") String code,
			@RequestParam("state") String state
			) {
		/*
		AccessTokenDTO sendInfo = new AccessTokenDTO(
				"63d788312d85033b391b",
				"1ce1d4a94a347f61627c1fd87d3902cfeb94cfc1",
				code,
				"http://localhost:8080/callback",
				state);
		*/
		
		accesstokendto.setCode(code);
		accesstokendto.setState(state);
		
		String url = "https://github.com/login/oauth/access_token";
		JSONObject json = JSONObject.fromObject(accesstokendto);
		
		String result = send.OkPost(url,json.toString());
		System.out.println(result);
		//access_token=67bac9cbfe1e601cd06afff4a530b78af9655d64&scope=user&token_type=bearer
		
		//处理 access_token
		String [] infos = result.split("&");
		String[] info = infos[0].split("=");
		String access_token = info[1];
		
		System.out.println("access_token : "  + access_token);
		
		//获取用户信息
		GitHubUser user = send.getUser(access_token);
		System.out.println(user);
		
		return "index";
		
		//localhost:8080/callback
		
	}
	
	
	
	
	
}
