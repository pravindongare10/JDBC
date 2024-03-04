package com.main.MultiStore_Procedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.main.sp.config.ProcedureCofiguration;

public class Multi_Stored_Procedures {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection con = ProcedureCofiguration.buildConnection();
		
		try {

			CallableStatement cs = con.prepareCall("{call multi_processing(?)}");
			System.out.println("Enter Product Id To Find : ");
			int id = sc.nextInt();
			cs.setInt(1, id);
		
			boolean b1=cs.execute();
			
			if(b1) {
			ResultSet rs =cs.getResultSet();
			
				while(rs.next())
				{
					System.out.println("Product Id : "+id+" | Product Name : "+rs.getString("pName"));
				}
			}
			
			if(cs.getMoreResults()) {
				ResultSet rs =cs.getResultSet();
				while(rs.next())
				{
					System.out.println("Product Type : "+rs.getString("ptype"));
				}
			}

			if(cs.getMoreResults()) {
				ResultSet rs =cs.getResultSet();
				while(rs.next())
				{
					System.out.println("Maximum Product Price in Table : "+rs.getString("pprice"));
				}
			}
			
			cs.close();
			con.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
