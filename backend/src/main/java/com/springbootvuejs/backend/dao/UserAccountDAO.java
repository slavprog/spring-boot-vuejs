package com.springbootvuejs.backend.dao;

import com.springbootvuejs.backend.entity.UserAccount;

import java.util.List;

public interface UserAccountDAO {

	public List<UserAccount> findAll();
	public void save(UserAccount transaction);
	
}
