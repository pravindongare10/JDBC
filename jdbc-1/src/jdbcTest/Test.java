package jdbcTest;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Test {
	Scanner sc=new Scanner(System.in);
	public void createTable() throws SQLException
	{
		Connection con=Establish.buildConnection();	
		Statement smt=con.createStatement();
		String s="CREATE TABLE EMP(empId int,empName varchar(50))";
		smt.execute(s);
		smt.close();
		con.close();
		System.out.println("Done");
	}
	public void insertdata() throws SQLException
	
	{  
		Connection con=Establish.buildConnection();
		Statement smt=con.createStatement();
		System.out.println("Enter Emp Id");
		int eid=sc.nextInt();
		System.out.println("Enter Emp Name");
		String name=sc.next();
		String s1="INSERT INTO EMP VALUES("+eid+",'"+name+"')";
		smt.execute(s1);
		smt.close();
		con.close();
		
		
	}
	public static void main(String[] args) throws SQLException {
		Test t=new Test();
		//t.createTable();
		t.insertdata();
	}
	

}
