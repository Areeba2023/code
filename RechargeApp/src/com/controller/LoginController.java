package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.RechargeDao;
import com.model.Login;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s1=request.getParameter("uname");
		String s2=request.getParameter("pass");
		PrintWriter out=response.getWriter();
	
		
		Login l=new Login();
		l.setName(s1);
		l.setPassword(s2);
		
		
	RechargeDao rd=new RechargeDao();
	boolean b=rd.validate(l);
	if(b)
	{
		response.sendRedirect("Recharge.jsp");
	}
	else
	{
		response.sendRedirect("Login.html");
	}
	/*else
	{
		RequestDispatcher rd1=request.getRequestDispatcher("Login.html");
		out.println("<font color=red>USer Name or PassWord is Wrong.</font>");
		out.println("4");
		response.sendRedirect("Login.html");
	}*/
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
