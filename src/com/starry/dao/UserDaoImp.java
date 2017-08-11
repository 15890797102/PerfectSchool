package com.starry.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.starry.entity.Department;
import com.starry.entity.User;
import com.starry.utils.MyJDBCUtils;

public class UserDaoImp implements UserDao {


	private List<User> userList=new ArrayList<User>();
	private List<Department> departmentList=new ArrayList<Department>();
	private User user=new User();
	private Department department=new Department();
	/*
	 * 重写借口中的查询方法
	 * 传入需要查询的账号，密码。查询数据库中有无匹配。
	 * @see com.starry.dao.UserDao#userSelect(java.lang.String)
	 */
	@Override
	public User userSelect(String UserName,String PassWord) {
		
		QueryRunner qr=new QueryRunner(MyJDBCUtils.getDataSource());
		Object[] params= {UserName,PassWord};
		String sql="select * from user where username=? and password=md5(?)";
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

	/*
	 * 这是一个新增用户的方法
	 * @see com.starry.dao.UserDao#insertUser(java.lang.String, java.lang.String)
	 */
	@Override
	public void insertUser(String UserName, String PassWord) {
		QueryRunner qr=new QueryRunner(MyJDBCUtils.getDataSource());
		Object[] params= {UserName,PassWord};
		String sql="INSERT INTO USER(username,PASSWORD,LEVEL) VALUE(?,MD5(?),1)";
	    try {
	    	qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	/*
	 * 这是一个更新用户信息的方法(non-Javadoc)
	 * @see com.starry.dao.UserDao#uptateUser(java.lang.String, java.lang.String)
	 */
	@Override
	public void uptateUser(String UserName, String PassWord,String UserName1, String PassWord1) {
		QueryRunner qr=new QueryRunner(MyJDBCUtils.getDataSource());
		Object[] params= {UserName,PassWord,UserName1,PassWord1};
		String sql="UPDATE	USER SET username=?,password=md5(?) WHERE username=? and password=?";
	    try {
	    	qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	/*
	 * 这是一个删除方法(non-Javadoc)
	 * @see com.starry.dao.UserDao#deleteUser(java.lang.String)
	 */
	@Override
	public void deleteUser(String UserName) {
		QueryRunner qr=new QueryRunner(MyJDBCUtils.getDataSource());
		Object[] params= {UserName};
		String sql="DELETE FROM USER WHERE username=?";
	    try {
	    	qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * 这是一个查询权限表的方法(non-Javadoc)
	 * 查询权限表，返回集合 ，然后在页面中foreach该集合
	 * @see com.starry.dao.UserDao#DepartmentList()
	 */
	@Override
	public List<Department> SelectDepart() {
		QueryRunner qr=new QueryRunner(MyJDBCUtils.getDataSource());
		Object[] params= {};
		String sql="select * from department";
	    try {
	    	departmentList=qr.query(sql,  new BeanListHandler<Department>(Department.class), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return departmentList;
	}

	/*
	 * 查询权限表的Id   METHOD
	 * (non-Javadoc)
	 * @see com.starry.dao.UserDao#SelectDepartId()
	 */
	@Override
	public int SelectDepartId(String name) {
		QueryRunner qr=new QueryRunner(MyJDBCUtils.getDataSource());
		Object[] params= {name};
		String sql="select department.department_id from department where department_name=?";
	    try {
	    	department=qr.query(sql,  new BeanHandler<Department>(Department.class), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return department.getDepartment_id();
	}
	/*
	 * 查询用户表的Id   METHOD
	 * (non-Javadoc)
	 * @see com.starry.dao.UserDao#SelectDepartId()
	 */
	@Override
	public int SelectUserId(String name) {
		QueryRunner qr=new QueryRunner(MyJDBCUtils.getDataSource());
		Object[] params= {name};
		String sql="select * from user where username=?";
	    try {
	    	user=qr.query(sql,  new BeanHandler<User>(User.class), params);
	    	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user.getUser_id();
	}

	/*
	 * //这是一个manage表的添加方法
	 * (non-Javadoc)
	 * @see com.starry.dao.UserDao#insertManage(int, int)
	 */
	@Override
	public void insertManage(int userId, int departId) {
		QueryRunner qr=new QueryRunner(MyJDBCUtils.getDataSource());
		Object[] params= {userId,departId};
		String sql="INSERT INTO manage VALUE(null,?,?)";
	    try {
	    	qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
