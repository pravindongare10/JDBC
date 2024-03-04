package Store_Procedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Insertdata {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/productdata","root","root");
			CallableStatement cs=con.prepareCall("{call addproduct(?,?,?,?)}");
			for(int i=1;i<=5;i++)
			{
				System.out.println("Enter id");
				int id=sc.nextInt();
			cs.setInt(1,id);
			System.out.println("Enter product Name");
			String name=sc.next();
			cs.setString(2,name);
			System.out.println("Enter price");
			Float price=sc.nextFloat();
			cs.setFloat(3,price);
			System.out.println("Enter product type");
			String type=sc.next();
			cs.setString(4,type);
			
			
			cs.execute();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
