package org.yeyz.fourm.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.yeyz.fourm.model.Question;
import org.yeyz.fourm.model.UserOracle;
import org.yeyz.fourm.service.IQuestionService;

@Controller
public class PublishController {	
	@Autowired
	IQuestionService questionService;
	
	
	
	@RequestMapping(value="/publish",method = RequestMethod.GET)
	public String publish() {
		return "publish";
	}
	
	@RequestMapping(value="/publish",method = RequestMethod.POST)
	public String doPublish(
		@RequestParam("title") String title,
		@RequestParam("description") String description,
		//@RequestParam("tag") String tag,
		HttpServletRequest request,
		HttpServletResponse response,
		Map<String,Object> map
			) {
		
		if(title == "") {
			map.put("error","标题不能为空");
			System.out.println("标题为空");
			return "publish";
		}
		
		/*
		 * 将 Question数据存入数据库
		 */
		//public Question(String title, String desvription, int creator, String tag, String gtm_create, String gtm_modified)
		
		
		HttpSession session = request.getSession();
		UserOracle user = (UserOracle)session.getAttribute("user");
		if(user == null) {
			//发送错误信息
			map.put("error","用户未登录");
			return "publish";
		}
		//获取主贴id
		Random ran = new Random();
		long temp = ran.nextLong();
		
		List<Question> questiones = questionService.queryQuestion();
		List<Long> checkId = new ArrayList<Long>();
		
		for(Question qs : questiones) {
			checkId.add(qs.getId());
		}
		
		while(checkId.contains(temp) && temp != 1) {
			temp = ran.nextLong();
		}
		
		System.out.println("主贴 id : " + temp);
		
		long id = temp;
		//获取id
		Long creator = user.getId();
		//获取时间
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		String gtm_create = sdf.format(new Date());
		
		Question question = new Question(id,title,description,creator,"",gtm_create,gtm_create);
		questionService.addQuestion(question);
		System.out.println(question);
		//发布成功 返回首页
		return "redirect:/";
	}
	
}
