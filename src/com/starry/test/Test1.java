package com.starry.test;

import org.junit.Test;

import com.starry.dao.UserDaoImp;

/*
 * 这是一个单元测试类
 */
public class Test1 {
	@Test
	public void add() {
		UserDaoImp ud=new UserDaoImp();
		ud.page();
	}
}
