package org.yeyz.fourm;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.yeyz.fourm.dto.LevelCommentDTO;
import org.yeyz.fourm.model.CommentTb;
import org.yeyz.fourm.model.LevelComment;
import org.yeyz.fourm.model.Question;
import org.yeyz.fourm.model.UserOracle;
import org.yeyz.fourm.service.ICommentTbService;
import org.yeyz.fourm.service.ILevelCommentService;
import org.yeyz.fourm.service.IQuestionService;
import org.yeyz.fourm.service.IUserOracleService;

@SpringBootTest
class SbFourm2ApplicationTests {

	@Autowired
	IUserOracleService service;
	@Autowired
	IQuestionService questionService;
	
	@Autowired
	ICommentTbService commentService;
	
	@Autowired
	ILevelCommentService levelCommentService;
	
	//@Test
	void contextLoads() {
	}

	//@Test
	void addLevel() {
		
		SimpleDateFormat sdf  = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		
		Long parentInfoId = Long.parseLong("123");
		//主键
		Long levelId = Long.parseLong("1234567");
		
		Long levelCommentator = Long.parseLong("1");
		
		String levelCommentContent = "小燕子小燕子新泽西州水水大多数";
		
		int like_count = 0;
		
		String gtm_create = sdf.format(new Date());
		
		LevelComment levelComment = new LevelComment(parentInfoId, levelId, 2, levelCommentator, levelCommentContent, like_count, gtm_create);
		
		levelCommentService.addLevelComment(levelComment);
		
		
		System.out.println("层级回复插入成功");
	}
	
	
	
	
	@Test
	void queryLevel() {
		
		System.out.println("共几条数据 : " + levelCommentService.queryLevelTotalCount((long)123));
		
		System.out.println(levelCommentService.queryLevelCommentByPage(1,2, (long)123 ));
		
	}
	
	
	
	
	
	
	
	
	
	
}