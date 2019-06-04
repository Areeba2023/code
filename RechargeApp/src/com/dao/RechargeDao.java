package com.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.Login;
import com.model.recharge;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.sql.Connection;




public class RechargeDao {

	Connection con=null;
	PreparedStatement ps = null;
	ResultSet rs  =null;
	public Connection getConnect()
	{
		try
		{
			
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123456789");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public int SaveData(List<recharge> lst)
	{
		recharge r = lst.get(0);
		con=getConnect();
		int i=0;
		try {
			ps=con.prepareStatement("insert into recharge values(?,?,?,?,?)");
			ps.setInt(1, r.getMobileno());
			ps.setString(2, r.getName());
			ps.setString(3,r.getPassword());
			ps.setInt(4,r.getAmount());
			ps.setString(5, r.getActType());
			i=ps.executeUpdate();
					con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	public boolean validate(Login l)
	{
		
		String s1 = l.getName();
		String s2 = l.getPassword();
		boolean s= false;
		con=getConnect();
		try {
			ps=con.prepareStatement("select name,password from recharge where name=? and password=?");
			ps.setString(1,s1);
			ps.setString(2,s2);
			rs=ps.executeQuery();
			if(rs.next())
			{
				s=true;
			}
			}
		catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
	   return s;
	}
	
	
	public int RetrieveData(int mob)
	{
		int i=0;
	  con=getConnect();
		ResultSet rs=null;
		System.out.println("2");
		try {
			 ps=con.prepareStatement("select amount from recharge where mobileno=?");
			ps.setInt(1,mob);
			rs=ps.executeQuery();
			System.out.println("3");
			if(rs.next()==true) {
				recharge r=new recharge();
				r.setAmount(rs.getInt(4));
				i= r.getAmount();
				
				con.close();
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	
	public boolean update(int mob, int money)
	{
		  con=getConnect();	
		  boolean b=false;
		  try {
				 ps=con.prepareStatement("update table recharge where mobileno=? and amount=?");
				ps.setInt(1,mob);
				ps.setInt(2, money);
			 b = ps.execute();
				System.out.println("3");
				}
			 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  return b;
	}
	
	/*public List<Register> Display()
	{
		 con=getConnect();
			ResultSet rs=null;
			
			List<Register> alst=new ArrayList<Register>();
			try {
				Statement st=con.createStatement();
				
				rs=st.executeQuery("select * from register");
				while(rs.next()) 
				{
					Register g=new Register(rs);
					
					g.setRno(rs.getInt(1));
					g.setName(rs.getString(2));
					g.setPassword(rs.getString(3));
					g.setMobile(rs.getInt(4));
					
					alst.add(g);
				}
					/*alst=new ArrayList<Register>();
						
					int r=rs.getInt(1);
					String nm=rs.getString(2);
					String pa=rs.getString(3);
					int r1=rs.getInt(4);
					//System.out.println(r+"\n"+unm+"\n"+pa);
					
					Register r11=new Register();
					r11.setRno(r);
					r11.setName(nm);
					r11.setPassword(pa);
					r11.setMobile(r1);
					alst.add(r11);
					
					
					con.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return alst;
} */
	
	
	
}
