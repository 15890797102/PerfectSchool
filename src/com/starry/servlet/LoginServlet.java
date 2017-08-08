package com.starry.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.starry.service.AccountService;

/**
 * 点击登录后跳转的servlet
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name= request.getParameter("username");
		String pass= request.getParameter("password");
		String num= request.getParameter("number");
		String code= request.getSession().getAttribute("codesave").toString();
		AccountService acs=new AccountService();
		System.out.println("name="+num);
		System.out.println("code="+code);
		boolean is= acs.userService(name,pass);
		if(is) {
			if(num.equals(code)) {
				request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
				return;
			}
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
			return;
		}else {
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
