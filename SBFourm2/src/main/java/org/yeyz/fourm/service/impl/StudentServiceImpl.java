package org.yeyz.fourm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.yeyz.fourm.entity.Student;
import org.yeyz.fourm.mapper.StudentMapper;
import org.yeyz.fourm.service.IStudentService;

@Component
public class StudentServiceImpl implements IStudentService {

	@Autowired
	StudentMapper mapper;
	
	@Override
	public List<Student> queryStu() {
		
		return mapper.queryStu();
	}

}
