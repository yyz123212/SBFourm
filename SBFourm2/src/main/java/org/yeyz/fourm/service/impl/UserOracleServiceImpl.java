package org.yeyz.fourm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.yeyz.fourm.mapper.UserOracleMapper;
import org.yeyz.fourm.model.UserOracle;
import org.yeyz.fourm.service.IUserOracleService;

@Component
public class UserOracleServiceImpl implements IUserOracleService{

	@Autowired
	private UserOracleMapper mapper ;
	
	
	
	public UserOracleMapper getMapper() {
		return mapper;
	}

	public void setMapper(UserOracleMapper mapper) {
		this.mapper = mapper;
	}

	
	
	@Override
	public List<UserOracle> queryUserOracle() {
		
		return mapper.queryUserOracle();
	}

	@Override
	@Transactional
	public void addUserOracle(UserOracle userOracle) {
		
		mapper.addUserOracle(userOracle);
		
	}

	@Override
	public UserOracle queryUserByToken(String token) {
	
		return mapper.queryUserByToken(token);
	}

	@Override
	public UserOracle queryUserById(Long creator) {
		// TODO Auto-generated method stub
		return mapper.queryUserById(creator);
	}

}
