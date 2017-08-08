package com.starry.dao;

import java.util.List;

import com.starry.entity.User;

public interface UserDao {
	//这是一个用户信息查询方法
	public User userSelect(String UserName,String PassWord);
	//这是一个查询用户等级的方法
	public User userLevel(String UserName,String PassWord);
	//这是一个分页查询功能的方法
	public List<User> userList(int nb);
	//这是一个获取当前总页数的方法
	public int page();
}
