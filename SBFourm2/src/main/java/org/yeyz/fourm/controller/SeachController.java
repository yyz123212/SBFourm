package org.yeyz.fourm.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
public class SeachController {
	@Autowired
	IUserOracleService service;
	@Autowired
	IQuestionService questionService;
	@Autowired
	ICommentTbService commentService;
	
	
	
	@RequestMapping(value="/seach",method = RequestMethod.POST)
	public String seach(
			@RequestParam("seachContent") String seachContent,
			HttpServletRequest request,
			HttpServletResponse response,
			//当前页
			@RequestParam(value="currentPage",defaultValue="1") int currentPage,
			Map<String,Object> map
			) {
		System.out.println("进来了");
		System.out.println(seachContent);
		
		System.out.println("当前页 : " + currentPage);
		System.out.println("搜索控制器");
		
		/*
		 * 发送 Question的数据
		 */
		
		// 1.总数据量
		int totalCount = questionService.queryTotalCountWithSeach(seachContent);
		// 2.每页显示多少条数据
		int pageSize = 10;
		// 3.当前页currentPage 在参数中
		// 4.总页数 totalPage 已经由构造方法计算
		
		List<Question> questiones = questionService.queryQuestionSeachPage(seachContent, currentPage, pageSize);
		
		if(seachContent.equals("")) {
			return "redirect:/";
		}
		
		
		if(questiones.size() == 0) {
			return "seachError";
		}
		
		System.out.println("questiones : " + questiones);
		List<UserOracle> users = service.queryUserOracle();
		
		List<QuestionDTO> questionDTOS = new ArrayList<QuestionDTO>();
		
		
		
		for(Question question : questiones) {
			
			
			
			//处理头像路径 将头像路径放入集合
			for(UserOracle user : users) {
				
				//如果id相同 则头像路径相同
				// 2个 Long 类型 不能直接 用 == 进行 比较
				if(question.getCreator().equals(user.getId()) ) {
					question.setComment_count( commentService.queryTotalCount( question.getId() ) );
					QuestionDTO questionDTO = new QuestionDTO(question,user.getAvatar_url());
					questionDTOS.add(questionDTO);
				}
			}	
		}
		
		/*
		 * 
		 */
		
		PageDTO pageDTO = new PageDTO(totalCount, pageSize, currentPage, questionDTOS);
		

		
		
		if(questiones != null) {
			map.put("pageDTO",pageDTO);
			map.put("seachContent",seachContent);
		}
		
		
		
		return "seach";
	}
	
	
	
	
	@RequestMapping(value="/seach",method = RequestMethod.GET)
	public String seach2(
			@RequestParam("seachContent") String seachContent,
			HttpServletRequest request,
			HttpServletResponse response,
			//当前页
			@RequestParam(value="currentPage",defaultValue="1") int currentPage,
			Map<String,Object> map
			) {
		System.out.println("进来了 GET");
		
		
		System.out.println("搜索控制器");
		
		/*
		 * 发送 Question的数据
		 */
		
		// 1.总数据量
		int totalCount = questionService.queryTotalCountWithSeach(seachContent);
		// 2.每页显示多少条数据
		int pageSize = 10;
		// 3.当前页currentPage 在参数中
		// 4.总页数 totalPage 已经由构造方法计算
		
		List<Question> questiones = questionService.queryQuestionSeachPage(seachContent, currentPage, pageSize);
		System.out.println("questiones : " + questiones);
		List<UserOracle> users = service.queryUserOracle();
		
		List<QuestionDTO> questionDTOS = new ArrayList<QuestionDTO>();
		
		
		
		for(Question question : questiones) {
			
			
			
			//处理头像路径 将头像路径放入集合
			for(UserOracle user : users) {
				
				//如果id相同 则头像路径相同
				// 2个 Long 类型 不能直接 用 == 进行 比较
				if(question.getCreator().equals(user.getId()) ) {
					question.setComment_count( commentService.queryTotalCount( question.getId() ) );
					QuestionDTO questionDTO = new QuestionDTO(question,user.getAvatar_url());
					questionDTOS.add(questionDTO);
				}
			}	
		}
		
		/*
		 * 
		 */
		
		PageDTO pageDTO = new PageDTO(totalCount, pageSize, currentPage, questionDTOS);
		

		
		
		if(questiones != null) {
			map.put("pageDTO",pageDTO);
			map.put("seachContent",seachContent);
		}
		
		
		
		return "seach";
	}
	
	
	
	
	
	
}
