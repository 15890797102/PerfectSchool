package com.starry.dao;

import com.starry.entity.User;

public interface UserDao {
	//这是一个用户信息查询方法
	public User userSelect(String UserName,String PassWord);
}
