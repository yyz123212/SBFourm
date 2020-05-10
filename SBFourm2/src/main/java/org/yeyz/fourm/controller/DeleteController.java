package org.yeyz.fourm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yeyz.fourm.model.CommentTb;
import org.yeyz.fourm.model.Question;
import org.yeyz.fourm.service.ICommentTbService;
import org.yeyz.fourm.service.ILevelCommentService;
import org.yeyz.fourm.service.IQuestionService;
import org.yeyz.fourm.service.IUserOracleService;

@Controller
public class DeleteController {

	@Autowired
	IUserOracleService service;
	@Autowired
	IQuestionService questionService;
	@Autowired
	ICommentTbService commentService;
	@Autowired
	ILevelCommentService levelCommentService;
	@ResponseBody
	@RequestMapping(value="/deleteQuestion",method = RequestMethod.POST)
	public Object deleteQuestion(
			@RequestParam(value = "id",defaultValue = "1") Long id,
			@RequestParam(value = "flag")boolean flag
				
			) {
		
		System.out.println(id);
		System.out.println("删除控制器 : " + flag);
		
		if( flag == true ) {
			List<CommentTb> comments = commentService.queryComment(id);
			
			
			for(CommentTb comment : comments) {
				levelCommentService.deleteLevelComment(comment.getId());
			}
			System.out.println("删除层级评论");
			
			commentService.deleteComment(id);
			System.out.println("删除一级评论");
			
			questionService.deleteQuestion(id);
			System.out.println("删除主题帖");
		}
		
		List<Question> questions = questionService.queryQuestion();
		return questions;
	}
	
	
	
	
	
	
}
