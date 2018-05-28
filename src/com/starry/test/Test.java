package com.starry.test;

import com.starry.dao.UserDaoImp;

/*
 * 这是一个测试类
 */
public class Test {
	public static void main(String[] args) {
		UserDaoImp ud=new UserDaoImp();
		ud.userLevel("starry", "6512bd43d9caa6e02c990b0a82652dca");
		ud.userLevel("starry1", "6512bd43d9caa6e02c990b0a82652dca");
		ud.userLevel("starry2", "6512bd43d9caa6e02c990b0a82652dca");
		ud.userLevel("starry3", "6512bd43d9caa6e02c990b0a82652dca");

	}
}
