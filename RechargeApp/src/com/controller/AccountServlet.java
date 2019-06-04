package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RechargeDao;


import com.model.recharge;

/**
 * Servlet implementation class AccountServlet
 */
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s1=request.getParameter("mob");
		String s2=request.getParameter("uname");
		String s3=request.getParameter("pass");
		String s4=request.getParameter("amt");
		String s5=request.getParameter("actType");
		
		recharge r = new recharge();
		r.setMobileno(Integer.parseInt(s1));
		r.setName(s2);
		r.setPassword(s3);
		r.setAmount(Integer.parseInt(s4));
		r.setActType(s5);
		
		List<recharge> lst = new ArrayList<recharge>();
		lst.add(r);
		
		RechargeDao rd = new RechargeDao();
		
		int i=rd.SaveData(lst);
		if(i>0)
		{
			response.sendRedirect("Login.html");
		}
		else
		{
			response.sendRedirect("account.jsp");
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
