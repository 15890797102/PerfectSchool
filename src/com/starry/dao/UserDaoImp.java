package com.starry.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.starry.entity.User;
import com.starry.utils.MyJDBCUtils;

public class UserDaoImp implements UserDao {
	private User user;
	/*
	 * 重写借口中的查询方法
	 * 传入需要查询的账号，密码。查询数据库中有无匹配。
	 * @see com.starry.dao.UserDao#userSelect(java.lang.String)
	 */
	@Override
	public User userSelect(String UserName,String PassWord) {
		
		QueryRunner qr=new QueryRunner(MyJDBCUtils.getDataSource());
		Object[] params= {UserName,PassWord};
		String sql="select * from user where username=? and password=?";
	    try {
		  user=qr.query(sql,  new BeanHandler<User>(User.class), params);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

}
