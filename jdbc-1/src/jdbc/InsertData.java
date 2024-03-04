package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertData {
	public static void main(String[] args) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		Statement smt=con.createStatement();
		//String sql1="create table Employee(eid int,name varchar(40))";
		String sql2="insert into Employee values(1,'xyz')";
		//smt.execute(sql1);
		smt.execute(sql2);
		String sql3="select *from Employee";
		ps=con.prepareStatement(sql3);
		rs=ps.executeQuery();
		while(rs.next()) {
        int eid=rs.getInt("eid");
	    String nm=rs.getNString("name");
	    System.out.println("Employee is:"+eid+   "Name: "+nm);
			
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("execute");
		
		
		}

}
