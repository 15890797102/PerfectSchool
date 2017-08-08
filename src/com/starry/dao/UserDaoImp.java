package com.starry.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.starry.entity.User;
import com.starry.utils.MyJDBCUtils;

public class UserDaoImp implements UserDao {
	private List<User> userList;
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
	
	
	/*
	 * 重写接口中的查询方法
	 * 传入需要查询的账号，密码。查询该账号的等级level。
	 * @see com.starry.dao.UserDao#userSelect(java.lang.String)
	 */
	@Override
	public User userLevel(String UserName, String PassWord) {
		QueryRunner qr=new QueryRunner(MyJDBCUtils.getDataSource());
		Object[] params= {UserName,PassWord};
		String sql="select level from user where username=? and password=?";
	    try {
		  user=qr.query(sql,  new BeanHandler<User>(User.class), params);
		  System.out.println(user.getLevel());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/*
	 * 这是一个分页查询功能的方法(non-Javadoc)
	 * @see com.starry.dao.UserDao#userList()
	 */
	@Override
	public List<User> userList(int nb) {
		QueryRunner qr=new QueryRunner(MyJDBCUtils.getDataSource());
		Object[] params= {nb};
		String sql="SELECT aa.`username`,aa.`password`,(GROUP_CONCAT(DISTINCT(dp.`department_name`)))AS jobName\r\n" + 
				"FROM (\r\n" + 
				"SELECT t1.`username`,t1.`password`,t2.`department_id`\r\n" + 
				"FROM `user` t1 LEFT JOIN manage t2\r\n" + 
				"ON t1.`user_id`=t2.`user_id`\r\n" + 
				") AS aa\r\n" + 
				"LEFT JOIN department dp\r\n" + 
				"ON aa.department_id=dp.`department_id`\r\n" + 
				"GROUP BY aa.username\r\n" + 
				"LIMIT ?,9";
	    try {
	    	userList=qr.query(sql,  new BeanListHandler<User>(User.class), params);
	    	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userList;
	}


	@Override
	public int page() {
		int sumPage = 0;
		QueryRunner qr=new QueryRunner(MyJDBCUtils.getDataSource());
		Object[] params= {};
		String sql="select count(*) as lo from user";
	    try {
	    	user=qr.query(sql,  new BeanHandler<User>(User.class), params);
	    	sumPage=user.getLo();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return sumPage;
	
	}

}
