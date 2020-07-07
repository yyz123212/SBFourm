package org.yeyz.fourm.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.Map;
import java.util.Random;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;

import org.yeyz.fourm.model.LevelComment;
import org.yeyz.fourm.model.Question;
import org.yeyz.fourm.model.UserOracle;
import org.yeyz.fourm.service.ICommentTbService;
import org.yeyz.fourm.service.ILevelCommentService;
import org.yeyz.fourm.service.IQuestionService;
import org.yeyz.fourm.service.IUserOracleService;

@Controller
public class LevelCommentController {

	@Autowired
	IUserOracleService service;
	@Autowired
	IQuestionService questionService;
	@Autowired
	ICommentTbService commentService;
	@Autowired
	ILevelCommentService levelCommentService;
	/*
	 * 层级回复
	 */
	
	@ResponseBody
	@RequestMapping(value="/levelComments",method = RequestMethod.POST)
	public String levelComments(
			LevelComment levelComment,
			HttpServletRequest request,
			HttpServletResponse response,
			
			Map<String,Object> map) {
	System.out.println("LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
		
		
	if(levelComment.getLevelCommentContent() == null || levelComment.getLevelCommentContent().equals("")) {
		map.put("commentNull","回复内容不能为空");
		return "question";
	}

	System.out.println("回复控制器");
	
	Long parentInfoId = levelComment.getParentInfoId();
	//获取回复信息id
	Random ran = new Random();
	Long temp = ran.nextLong();
		
	List<LevelComment> levelComments = levelCommentService.queryLevelComment(parentInfoId);
	List<Long> checkId = new ArrayList<Long>();
			
	for(LevelComment lc : levelComments) {
		checkId.add(lc.getLevelId());
	}
			
	while(checkId.contains(temp) && temp != 1) {
		temp = ran.nextLong();
	}
			
	System.out.println("回复 id : " + temp);		
	
	Long levelId = temp;
	
	int type = 2;
	//判断是否登录
	UserOracle userComment = (UserOracle)request.getSession().getAttribute("user");
	Long levelCommentator = (long) 1;
	System.out.println("回复人未变化 id : " + levelCommentator) ;
	
	/*
	 * 登录才能执行的操作
	 */if(userComment != null) {
		 System.out.println("回复控制器 : 登录l");
		 levelCommentator = userComment.getId();
	 }
	 System.out.println("回复人 id : " + levelCommentator) ;
	
	String levelCommentContent = levelComment.getLevelCommentContent();
	int like_count = 0;
	
	//获取时间
	SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
	String gtm_create = sdf.format(new Date());
	
	LevelComment addLevelComment = new LevelComment(parentInfoId, levelId, type, levelCommentator, levelCommentContent, like_count, gtm_create);
	System.out.println("addLevelComment : " + addLevelComment);
	
	
	levelCommentService.addLevelComment(addLevelComment);
	map.put("userComment",userComment);
	
	
	Question question = questionService.queryQuestionByThemeId(parentInfoId);
	map.put("question",question);
		
	
	
	
	
		return "question";
	}
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


/*
@RequestParam(value="parentId") Long parentId, 	  // 	主贴 Id
@RequestParam(value="conten") String content,	 // 	回复内容
@RequestParam(value="type") int type,			//	 	判断是回复层级
*/