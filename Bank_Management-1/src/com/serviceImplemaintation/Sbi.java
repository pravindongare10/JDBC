package com.serviceImplemaintation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.model.Account;
import com.service.Rbi;
import com.utility.Configuration;

public class Sbi implements Rbi{
	Scanner sc=new Scanner(System.in);

	Account ac=new Account();
	
	@Override
	public void createAccount() {
		
		System.out.println("Enter Account Number");
		ac.setAccountNumber(sc.nextLong());
		System.out.println("Enter Account Holder Name");
		ac.setAccountHolderName(sc.next());
		System.out.println("Enter AdharNumber");
		ac.setAdharNumber(sc.nextLong());
		System.out.println("Enter Account Holder Gender");
		ac.setGender(sc.next());
		System.out.println("Enter Account Holder Age");
		ac.setAge(sc.nextInt());
		System.out.println("Enter Account AccountBalance");
		ac.setAccountBalance(sc.nextDouble());
	Connection con=Configuration.buildConnection();
	String sql="insert into Account values(?,?,?,?,?,?)";
	try {
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setLong(1,ac.getAccountNumber());
		ps.setString(2,ac.getAccountHolderName());
		ps.setLong(3,ac.getAdharNumber());
		ps.setString(4,ac.getGender());
		ps.setInt(5,ac.getAge());
		ps.setDouble(6,ac.getAccountBalance());
		ps.executeUpdate();
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}	
	}

	@Override
	public void displayAccountDetails() {
		
		Connection con=Configuration.buildConnection();
		String sql="select*from Account";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println("Account Number :"+rs.getLong(1));
				System.out.println("Account Holder Name :"+rs.getString(2));
				System.out.println("AdharNumber :"+rs.getLong(3));
				System.out.println("Gender :"+rs.getString(4));
				System.out.println("Age :"+rs.getInt(5));
				System.out.println("Account Balance :"+rs.getDouble(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void checkAccountBalance() {
	
	 Connection con=Configuration.buildConnection();
	 String sql="select accountBalance from Account where accountNumber=? ";
	 try {
		PreparedStatement ps=con.prepareStatement(sql);
		System.out.println("Select Account Number for Check Balance");
		
		displayAccountDetails();
		System.out.println("Enter Account Number");
		long acnumber=sc.nextLong();
		ps.setLong(1, acnumber);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			System.out.println("Your Account Balance: "+rs.getLong(1));
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	 
		
	}

	@Override
	public void depositAmmount() {
		
		Connection con=Configuration.buildConnection();
		String sql="select accountBalance from Account where accountNumber=?";
		
		
	
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("All Account Number For Deposit Balance");
			displayAccountDetails();
			System.out.println("Enter Account Number");
			long x=sc.nextLong();
			ps.setLong(1,x);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
			
			
			String sql1="update Account set accountBalance=? where accountNumber=?";
			PreparedStatement ps1 = con.prepareStatement(sql1);
			
            double balance=rs.getDouble("accountBalance");
			
			System.out.println("Enter Deposite Ammount");
			double da=sc.nextDouble();
			double newbalance=balance+da;
			
			ps1.setDouble(1,newbalance);
			ps1.setLong(2, x);
			ps1.execute();
			System.out.println("Updated Balance: "+newbalance);
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		
	}
  
	@Override
	public void withdrowAmmount() {
		
		
		Connection con=Configuration.buildConnection();
		String sql="select accountBalance from Account where accountNumber=?";
		
		
	
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("All Account Number For Withdraw Balance");
			displayAccountDetails();
			System.out.println("Enter Account Number");
			long x=sc.nextLong();
			ps.setLong(1,x);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
			
			
			String sql1="update Account set accountBalance=? where accountNumber=?";
			PreparedStatement ps1 = con.prepareStatement(sql1);
			
            double balance=rs.getDouble("accountBalance");
			
			System.out.println("Enter Withdraw Ammount");
			double da=sc.nextDouble();
			double newbalance=balance-da;
			
			ps1.setDouble(1,newbalance);
			ps1.setLong(2, x);
			ps1.execute();
			System.out.println("Updated Balance: "+newbalance);
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		
		
		
	}

}
