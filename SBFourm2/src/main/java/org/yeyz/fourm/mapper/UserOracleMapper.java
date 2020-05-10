package org.yeyz.fourm.mapper;

import java.util.List;

import org.yeyz.fourm.model.UserOracle;

public interface UserOracleMapper {

	public List<UserOracle> queryUserOracle();
	
	public void addUserOracle(UserOracle userOracle);
	
	
	public UserOracle queryUserByToken(String token);
	
	
	public UserOracle queryUserById(Long creator);
	
}
