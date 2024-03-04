package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test {
	public static void main(String[] args) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		
		String sql="create table stu(roll int primary key,name varchar(40))";
		String sql2="insert into stu values(1,'abx'),(2,'xyz'),(3,'pqr')";
		Statement smt=con.createStatement();
		smt.execute(sql);
		smt.execute(sql2);
		smt.close();
		con.close();
		
		}
			
	catch (Exception e) {
		e.printStackTrace();
	}
	}

}
