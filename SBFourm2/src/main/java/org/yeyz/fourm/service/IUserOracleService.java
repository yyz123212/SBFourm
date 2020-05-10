package org.yeyz.fourm.service;

import java.util.List;

import org.yeyz.fourm.model.UserOracle;

public interface IUserOracleService {

	public List<UserOracle> queryUserOracle();
	public void addUserOracle(UserOracle userOracle);
	public UserOracle queryUserByToken(String token);

	public UserOracle queryUserById(Long creator);
}
