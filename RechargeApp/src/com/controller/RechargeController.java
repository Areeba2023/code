package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.RechargeDao;
import com.model.Login;
import com.model.recharge;

/**
 * Servlet implementation class RechargeController
 */
public class RechargeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechargeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s1=request.getParameter("mob");
		String s2=request.getParameter("amt");
		String s3=request.getParameter("oper");
		PrintWriter out=response.getWriter();
		
		int n1=Integer.parseInt(s1);
		int n2=Integer.parseInt(s2);
		
		recharge r=new recharge();
		r.setAmount(n2);
		
	RechargeDao rd=new RechargeDao();
	int a=rd.RetrieveData(n1);
	System.out.println("1");
	if((a<n2)==true)
	{
		//int n=a-n2;
		//boolean b=rd.update(n1,n);
		System.out.println("4");
		//if(b==true)
		response.sendRedirect("Home.html");
		//else
		//	out.println("amount is not updated");
	}
	else
	{
		System.out.println("5");
		out.println("enter lesser amount");
	}
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
