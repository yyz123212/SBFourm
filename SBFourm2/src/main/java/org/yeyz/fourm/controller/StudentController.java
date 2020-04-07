package org.yeyz.fourm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.yeyz.fourm.entity.Student;
import org.yeyz.fourm.service.IStudentService;
//测试用 学生类控制器
@Controller

public class StudentController {

	@Autowired
	IStudentService service;
	
	@RequestMapping(value="/testQuery")
	public String testQuery(Map<String,Object> map) {
	
		
		List <Student> students = service.queryStu();
		
		map.put("students",students);
		
		return "fourm";
		
	}
	// localhost:8080/testQuery
	
}
