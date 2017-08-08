package com.starry.entity;
/*
 * 这是一个User用户表的javabean类
 * 实体类
 */
public class User {
	//成员变量
	private int id;
	private String username;
	private String password;
	private int level;
	private String session;
	private int state_code;
	//构造方法
	public User() {
		super();
	}
	public User(int id, String username, String password, int level, String session, int state_code) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.level = level;
		this.session = session;
		this.state_code = state_code;
	}
	//属性
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	public int getState_code() {
		return state_code;
	}
	public void setState_code(int state_code) {
		this.state_code = state_code;
	}
	//成员方法
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", level=" + level
				+ ", session=" + session + ", state_code=" + state_code + "]";
	}
	
	
}
