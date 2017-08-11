package com.starry.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.starry.entity.User;
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
		String num= request.getParameter("verify");
		request.getSession().setAttribute("name", name);
		
		String code= (String) request.getSession().getAttribute("codesave");
			AccountService acs=new AccountService();
			User user= acs.userService(name,pass);
			
			if(user!=null) {
				if(code!=null) {
				if(num.equals(code)) {					
					if(user.getLevel()==0) {
						System.out.println(user.getLevel());
						request.getSession().setAttribute("level",0);
					}else {
						request.getSession().setAttribute("level",1);
					}
					request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
					return;
				}
				request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
				return;
			}else {
				request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
			}
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
