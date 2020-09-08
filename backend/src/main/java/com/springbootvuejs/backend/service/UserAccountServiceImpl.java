package com.springbootvuejs.backend.service;

import com.springbootvuejs.backend.dao.UserAccountDAO;
import com.springbootvuejs.backend.entity.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

	private UserAccountDAO userAccountDAO;

	@Autowired
	public UserAccountServiceImpl(UserAccountDAO userAccountDAO) {
		this.userAccountDAO = userAccountDAO;
	}
	
	@Override
	@Transactional
	public UserAccount findOne() {
		List<UserAccount> userAccounts = userAccountDAO.findAll();
		if (userAccounts != null && userAccounts.size() > 0){
			return userAccounts.get(0);
		}
		return null;
	}

	@Override
	@Transactional
	public void save(UserAccount userAccount) {
		userAccountDAO.save(userAccount);
	}

}






