package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnectivity {
	static Connection con=null;
	public static Connection buildConnection()
	{
		if(con==null)
		{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","root");
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		return con;
		
	}
	

}
