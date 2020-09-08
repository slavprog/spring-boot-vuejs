package com.springbootvuejs.backend.rest;

import com.springbootvuejs.backend.entity.Transaction;
import com.springbootvuejs.backend.entity.UserAccount;
import com.springbootvuejs.backend.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class UserAccountRestController {

	private UserAccountService userAccountService;

	@Autowired
	public UserAccountRestController(UserAccountService userAccountService) {
		this.userAccountService = userAccountService;
	}
	
	@GetMapping()
	public UserAccount findOne() {
		return userAccountService.findOne();
	}


	@PostMapping("/users")
	public UserAccount addUserAccountEntity(@RequestBody UserAccount userAccount) {

		userAccountService.save(userAccount);

		return userAccount;
	}
}










