package Project_PRODUCT;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.CallableStatement;

public class Test {
	Scanner sc=new Scanner(System.in);
	
	public void addproduct() throws SQLException
	{
		
		Connection con=Configuration.buildConnection();	
		CallableStatement cs=(CallableStatement) con.prepareCall("{call addproduct(?,?,?,?)}");
		System.out.println("Enter how many product you want to add");
		int x=sc.nextInt();
		for(int i=1;i<=x;i++ )
		{
		System.out.println("enter product id");
		int id=sc.nextInt();
		cs.setInt(1, id);
		System.out.println("Enter product Name");
		String s=sc.next();
		cs.setString(2, s);
		System.out.println("enter product price");
		float f=sc.nextFloat();
		cs.setFloat(3, f);
		System.out.println("Enter product type ");
		String s2=sc.next();
		cs.setString(4, s2);
		cs.execute();
		}
	}
	public void viewproduct() throws SQLException
	{
		Connection con=Configuration.buildConnection();	
		CallableStatement cs=(CallableStatement) con.prepareCall("{call addproduct(?,?,?,?)}");
		
	}
	public void updateproduct() throws SQLException
	{
		Connection con=Configuration.buildConnection();	
		CallableStatement cs=(CallableStatement) con.prepareCall("{call addproduct(?,?,?,?)}");
	}
	
public static void main(String[] args) throws SQLException {
	Test t=new Test();
	t.addproduct();
	
}
}
