package org.yeyz.fourm.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.yeyz.fourm.dto.PageDTO;
import org.yeyz.fourm.dto.QuestionDTO;
import org.yeyz.fourm.model.Question;
import org.yeyz.fourm.model.UserOracle;
import org.yeyz.fourm.service.ICommentTbService;
import org.yeyz.fourm.service.IQuestionService;
import org.yeyz.fourm.service.IUserOracleService;


@Controller
public class PersonalController {
	
	@Autowired
	IUserOracleService service;
	@Autowired
	IQuestionService questionService;
	@Autowired
	ICommentTbService commentService;
	//动态接收地址
	@RequestMapping(value="personal/{action}",method = RequestMethod.GET)
	public String personal(
			@PathVariable("action") String action,
			HttpServletRequest request,
			HttpServletResponse response,
			//当前页
			@RequestParam(value="currentPage",defaultValue="1") int currentPage,
			Map<String,Object> map
			
			) {
		
		
		
		UserOracle user = (UserOracle)request.getSession().getAttribute("user");
		
		if(user == null) {
			return "redirect:/";
		}
		
		if("questions".equals(action)) {
			map.put("section","questions");
			map.put("sectionName","我的主贴");
		}else if("replies".equals(action)) {
			map.put("section","replies");
			map.put("sectionName","最新回复");
		}
		
		/*
		 * 发送分页数据
		 */
		System.out.println("PersonalController ******************");
		System.out.println(user);
		
			Long userId = user.getId();
			// 1.总数据量
			int totalCount = questionService.queryTotalCountWithPersonal(userId);
			// 2.每页显示多少条数据
			int pageSize = 10;
			// 3.当前页currentPage 在参数中
			// 4.总页数 totalPage 已经由构造方法计算
					
			List<Question> questiones = questionService.queryQuestionByPageWithPersonal(currentPage, pageSize, userId);
					
			List<QuestionDTO> questionDTOS = new ArrayList<QuestionDTO>();
				
			for(Question question : questiones) {
				//处理头像路径 将头像路径放入集合
				question.setComment_count( commentService.queryTotalCount( question.getId() ) );
				QuestionDTO questionDTO = new QuestionDTO(question,user.getAvatar_url());
				questionDTOS.add(questionDTO);
			}
			PageDTO pageDTO = new PageDTO(totalCount, pageSize, currentPage, questionDTOS);
			
			if(questiones != null) {
				map.put("pageDTO",pageDTO);
			}
	
		return "personal";
	}
	
	
	
}

