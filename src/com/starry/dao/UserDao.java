package com.starry.dao;

import java.util.List;

import com.starry.entity.Department;
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
	//这是一个新增用户的方法
	public void insertUser(String UserName,String PassWord);
	//这是一个更新信息的方法
	public void uptateUser(String UserName,String PassWord,String UserName1, String PassWord1);
	//这是一个删除用户的方法
	public void deleteUser(String UserName);
	//这是一个查询权限表的方法
	public List<Department> SelectDepart();
	//这是一个查询权限表的id方法
	public int SelectDepartId(String name);
	//这是一个查询用户表的id方法
	public int SelectUserId(String name);
	//这是一个manage表的添加方法
	public void insertManage(int userId,int departId);
}



