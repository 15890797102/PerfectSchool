package com.starry.entity;

public class PageBean {
	//成员变量
	//定义一个小集合
	private int pg;
	public int getPg() {
		return pg;
	}
	public void setPg(int pg) {
		this.pg = pg;
	}
	//定义当前页码
	private int nowPage;
	//定义获取到的总数
	private int sumPage;
	//构造方法
	public PageBean() {
		super();
	}
	public PageBean(int nowPage, int sumPage) {
		super();
		this.nowPage = nowPage;
		this.sumPage = sumPage;
	}
	//属性
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = (nowPage-1)*9;
	}

	public int getSumPage() {
		return sumPage;
	}
	public void setSumPage(int sumPage) {
		this.sumPage = sumPage;
	}
	//成员方法
	@Override
	public String toString() {
		return "PageBean [nowPage=" + nowPage + ", sumPage=" + sumPage + "]";
	}
	
}
