package com.starry.service;

import java.util.ArrayList;
import java.util.List;

import com.starry.dao.UserDao;
import com.starry.dao.UserDaoImp;
import com.starry.entity.Department;
import com.starry.entity.PageBean;
import com.starry.entity.User;

public class AccountService {
	
	//登录账号密码判断的方法
	public User userService(String username,String password) {
		UserDao ud=new UserDaoImp();
		User user= ud.userSelect(username, password);
			return user;
	}
	//账户管理的分页显示方法
	public List<User> userList(int nb){
		UserDao ud=new UserDaoImp();
		List<User> user=ud.userList(nb);
		
		return user;
	}
	
	//获取总页数的方法
	public List<PageBean> pageList(){
		UserDao ud=new UserDaoImp();
		int num=(ud.page()%9==0)?0:1;
		int a=ud.page()/9+num;
		List<PageBean> list=new ArrayList<PageBean>();
		for(int i=1;i<=a;i++) {
			PageBean pb=new PageBean();
			pb.setPg(i);
			list.add(pb);
		}
				
		return list;
	}
	
	//获取总页数的方法
	public int pageList1(){
		UserDao ud=new UserDaoImp();
		int num=(ud.page()%9==0)?0:1;
		int a=ud.page()/9+num;
				
		return a;
	}
	
	//新增用户的方法
		public void insertUser(String UserName, String PassWord){
			UserDao ud=new UserDaoImp();
			ud.insertUser(UserName, PassWord);
		}
	//新增用户信息的方法
		public void updateUser(String UserName, String PassWord,String UserName1, String PassWord1){
			UserDao ud=new UserDaoImp();
			ud.uptateUser(UserName, PassWord, UserName1, PassWord1);
		}	
	//新增用户的方法
		public void deleteUser(String UserName){
			UserDao ud=new UserDaoImp();
			ud.deleteUser(UserName);
		}	
	//新增用户的方法
		public List<Department> selectDepart(){
			UserDao ud=new UserDaoImp();
			return ud.SelectDepart();
		}
	//查询权限表Id的方法
		public int SelectDepartId(String name){
			UserDao ud=new UserDaoImp();
			return ud.SelectDepartId(name);
		}
	//查询权限表Id的方法
		public int SelectUserId(String name){
			UserDao ud=new UserDaoImp();
			return ud.SelectUserId(name);
		}
		
	//查询权限表Id的方法
		public void insertManage(int userId, int departId){
			UserDao ud=new UserDaoImp();
			ud.insertManage(userId, departId);
		}
}
