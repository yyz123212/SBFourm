package org.yeyz.fourm.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerInterceptor;
import org.yeyz.fourm.model.UserOracle;
import org.yeyz.fourm.service.IQuestionService;
import org.yeyz.fourm.service.IUserOracleService;


@Configuration
public class MyThemeInterceptor implements HandlerInterceptor{
	
	@Autowired
	IUserOracleService service;
	@Autowired
	IQuestionService questionService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null && cookies.length != 0) {
			for(Cookie cookie : cookies) {
				
				if( cookie.getName().equals("token") ) {
					
					String token = cookie.getValue();
					UserOracle user = service.queryUserByToken(token);
						
					if( user != null ) {
						HttpSession session = request.getSession();
						session.setAttribute("user",user);
						
					}
					
					break;
				} // cookie.getName().equals("token")
				
			}
		}
		//返回 true代表继续执行
		return true;
	}
	
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	
	}
	
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	
	}
	
	
}
