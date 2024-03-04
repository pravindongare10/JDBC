package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			String sql="Create table Slist(sid int primary key,sname varchar(40))";
			Statement smt=con.createStatement();
			smt.execute(sql);
			smt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
			
			

}


