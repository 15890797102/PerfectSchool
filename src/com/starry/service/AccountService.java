package com.starry.service;

import com.starry.dao.UserDao;
import com.starry.dao.UserDaoImp;
import com.starry.entity.User;

public class AccountService {

	public boolean userService(String username,String password) {
		UserDao ud=new UserDaoImp();
		User user= ud.userSelect(username, password);
		if(user!=null) {
			return true;
		}
		return false;
	}
}
