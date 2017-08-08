package com.starry.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.starry.entity.PageBean;
import com.starry.entity.User;
import com.starry.service.AccountService;

/**
 * 跳转到小界面1
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取当前总页数
		AccountService acs=new AccountService();
	/*	List<PageBean> pageList=acs.pageList();
		request.getSession().setAttribute("pageList", pageList);*/
		
		int pagemax=acs.pageList1();
		request.getSession().setAttribute("pagemax", pagemax);
		//获取当前页数
		String num=(String) request.getParameter("hes");
		//System.out.println(num);
		if(num==null||num.equals("")) {
			num="1";
		}
		int number=Integer.parseInt(num) ;
		PageBean pb=new PageBean();
		request.getSession().setAttribute("nowPage", number);
		pb.setNowPage(number);
				
		List<User> userList=acs.userList(pb.getNowPage());
		request.getSession().setAttribute("userList", userList);
		
		request.getRequestDispatcher("/WEB-INF/AccountManagement.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
