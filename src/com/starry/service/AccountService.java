package com.starry.service;

import java.util.ArrayList;
import java.util.List;

import com.starry.dao.UserDao;
import com.starry.dao.UserDaoImp;
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
}
