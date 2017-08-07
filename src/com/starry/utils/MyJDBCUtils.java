package com.starry.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


/**
 * 自定义的JDBC工具类,
 * 
 * 
 * @author jerry
 * @version 1.2
 * 使用数据库连接池来创建Connection对象
 * 使用c3p0来改造
 * 作为 DriverManager 工具的替代项，DataSource 对象是获取连接的首选方法。
 * @since 2017-06-12 14:16  
 */
public class MyJDBCUtils {
	
	//因为c3p0 使用默认的配置文件
	static ComboPooledDataSource cpds = new ComboPooledDataSource();
	
	//无参构造方法私有化，为了抑制jvm自动帮我们添加public的无参构造方法
	private MyJDBCUtils(){
		
	}
	
	/**
	 * 获取一个Connection对象
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		
		Connection con = cpds.getConnection();
		
		return con;
	}
	
	/**
	 * 这个就是返回的一个我们创建的数据库连接池对象
	 * @return
	 */
	public static DataSource getDataSource() {
		return cpds;
	}
	/**
	 * 关闭数据库的连接
	 * @param rs
	 * @param stmt
	 * @param con
	 */
	public static void myClose(ResultSet rs,Statement stmt,Connection con){
		if (rs != null) {
			try {
				rs.close(); // 这句话会抛出NullpointerException
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	
	

}