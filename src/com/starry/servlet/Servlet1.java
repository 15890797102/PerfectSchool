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
		
		AccountService acs=new AccountService();
		//添加功能
		String insertName=request.getParameter("insertName");
		String insertPass=request.getParameter("insertPass");
		if(insertName!=null&&insertPass!=null) {
			acs.insertUser(insertName, insertPass);
		}
		//删除功能
		String deleteName=request.getParameter("deleteName");
		if(deleteName!=null) {
			System.out.println("开始执行删除方法");
			acs.deleteUser(deleteName);

		}
		
		//添加权限功能
		
		request.getSession().setAttribute("depart", acs.selectDepart());

		String userName=request.getParameter("userId");//获取查询当前需要添加权限的用户的名字
		String departName=request.getParameter("departId");//获取查询当前权限的名字
		if(userName!=null&&departName!=null) {
			System.out.println("userName=="+userName);
			System.out.println("departName=="+departName);
			int userId=acs.SelectUserId(userName);
			int departId=acs.SelectDepartId(departName);
			acs.insertManage(userId, departId);
		}
		//更新功能
		String updateName1=request.getParameter("updateName1");
		String updatePass1=request.getParameter("updatePass1");
		String updateName=request.getParameter("updateName");
		String updatePass=request.getParameter("updatePass");
		if(updateName1!=null&&updatePass1!=null&&updateName!=null&&updatePass!=null) {
			acs.updateUser(updateName1, updatePass1, updateName, updatePass);
		}
		//获取当前总页数
	
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
