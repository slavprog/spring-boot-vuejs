package com.springbootvuejs.backend.service;

import com.springbootvuejs.backend.entity.UserAccount;

public interface UserAccountService {

	public UserAccount findOne();


	public void save(UserAccount userAccount);
}
