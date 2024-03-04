package com.main.sp.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class ProcedureCofiguration {
	static Connection con=null;
	public static Connection buildConnection()
	{
		if(con==null)
		{
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/productdata","root","root");
				return con;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return con;
	}                       
}
