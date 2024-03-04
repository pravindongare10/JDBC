 package sql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertData {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			String sql="insert into student values(?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			for(int i=1;i<4;i++)
			{
			System.out.println("Enter Student id");
			int id=sc.nextInt();
			System.out.println("Enter Student name");
			String name=sc.next();
			
			ps.setInt(1,id);
			ps.setString(2,name);
			
			ps.execute();
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
