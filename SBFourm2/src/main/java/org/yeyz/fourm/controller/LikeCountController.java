package org.yeyz.fourm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yeyz.fourm.model.CommentTb;
import org.yeyz.fourm.service.ICommentTbService;
import org.yeyz.fourm.service.ILevelCommentService;
import org.yeyz.fourm.service.IQuestionService;
import org.yeyz.fourm.service.IUserOracleService;

@Controller
public class LikeCountController {
	@Autowired
	IUserOracleService service;
	@Autowired
	IQuestionService questionService;
	@Autowired
	ICommentTbService commentService;
	@Autowired
	ILevelCommentService levelCommentService;
	
	@ResponseBody
	@RequestMapping(value="/likeCount",method = RequestMethod.POST)
	public Object likeCount(@RequestParam(value = "id",defaultValue = "1") Long id) {
		
		System.out.println("点赞控制器");
		
		CommentTb comment = commentService.queryCommentById(id);
		int new_like_count = 0;
		synchronized (this) {
			new_like_count = comment.getLike_count() + 1;
			
			commentService.updataCommentLikeCount(new_like_count, id);
		}
		
		System.out.println("点赞 + 1");
		
		return new_like_count;
	}
	
}
