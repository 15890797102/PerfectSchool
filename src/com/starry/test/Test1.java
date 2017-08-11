package com.starry.test;

import org.junit.Test;

import com.starry.dao.UserDaoImp;
import com.starry.service.NewsService;

/*
 * 这是一个单元测试类
 */
public class Test1 {
	@Test
	public void add() {
		UserDaoImp ud=new UserDaoImp();
		ud.insertUser("jerry", "123456");
		NewsService ns=new NewsService();
		ns.insertNews("s", "s", "s", "s");
		
		
	}
}
