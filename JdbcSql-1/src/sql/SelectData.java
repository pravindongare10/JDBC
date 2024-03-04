package sql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectData {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			String sql1="select *from student";
			PreparedStatement ps=con.prepareStatement(sql1);
			ResultSet rs1=ps.executeQuery();
			while(rs1.next())
			{
			System.out.println(rs1.getInt("id"));
			System.out.println(rs1.getString("name"));
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
