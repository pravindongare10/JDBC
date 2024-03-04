package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Configuration {
	public static Connection con = null;

	public static Object Connect;

	public static Connection buildConnection () {

	System.out.println("--- MySQL JDBC Connection Testing -----");

	try {

	     Class.forName("com.mysql.cj.jdbc.Driver"); //loading the driver

	    } catch (ClassNotFoundException e) {

	    System.out.println("Where is your MySQL JDBC Driver?");
	    e.printStackTrace();
	    return con;

	    }

	System.out.println("MySQL JDBC Driver Registered!");

	try {

	     //Connect to the database
	     con = DriverManager.getConnection
	     ("jdbc:mysql://localhost:3306/bank_Account", "root", "root");

	    } catch (SQLException e) {

	    System.out.println("Connection Failed! Check output console");
	    e.printStackTrace();
	    return con;
	    }

	if (con != null) {
	System.out.println("You made it, take control your database now!");

	} else {
	System.out.println("Failed to make connection!");
	}
	return con;
	}

}
