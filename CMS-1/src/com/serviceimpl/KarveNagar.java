  package com.serviceimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.model.Batch;
import com.model.Course;
import com.model.Faculty;
import com.model.Student;
import com.service.Cjc;
import com.utility.JdbcConnectivity;

public class KarveNagar implements Cjc{
Scanner sc=new Scanner(System.in);
	public void addCourse() {
		System.out.println("Add Course");
		Course c=new Course();
		System.out.println("Enter course Id");
		c.setCid(sc.nextInt());
		System.out.println("Enter Course Name");
		c.setCname(sc.next());
		
		
		try {
			Connection con=JdbcConnectivity.buildConnection();
			String sql="insert into course values(?,?)"; 
			
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, c.getCid());
			ps.setString(2,c.getCname());
			ps.execute();
			System.out.println("**Succeesfully**");
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		
		
		 
	}
	@Override
	public void viewcourse() {
	System.out.println("Course Details");
	
	try {
		Connection con=JdbcConnectivity.buildConnection();
		String sql="select*from course";
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
		
	}
	@Override
	public void addFaculty() {
		Connection con=JdbcConnectivity.buildConnection();
		Faculty f=new Faculty();
		System.out.println("Enter Faculty Id");
		f.setFid(sc.nextInt());
		System.out.println("Enter Faculty Name");
		f.setFname(sc.next());
		System.out.println("Select any Course to faculty by Id");
		viewcourse();
		System.out.println("Enter Course Id");
		int cid=sc.nextInt();
		try {
			
			String sql="select*from course where cid=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, cid);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				Course c=new Course();
				c.setCid(rs.getInt(1));
				c.setCname(rs.getString(2));
				f.setCourse(c);
				String sql1="insert into faculty values(?,?,?,?)"; 
				
				PreparedStatement ps1=con.prepareStatement(sql1);
				ps1.setInt(1,f.getFid());
				ps1.setString(2,f.getFname());
				ps1.setInt(3,f.getCourse().getCid());
				ps1.setString(4,f.getCourse().getCname());
				ps1.execute();
				System.out.println("**Faculty Succeesfully added**");
				
			}
			else
			{
				System.out.println("Enter valid Course Id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	@Override
	public void viewFaculty() {
		Connection con=JdbcConnectivity.buildConnection();
		String sql="select*from faculty";
	try {	
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
	    System.out.println("Faculty Id :"+rs.getInt(1));
	    System.out.println("Faculty Name :"+rs.getString(2));
	    System.out.println("Course Id :"+rs.getInt(3));
	    System.out.println("Course Name :"+rs.getString(4));
		}
	} catch (SQLException e)
	{
		e.printStackTrace();
	}
	}
	
	@Override
	public void addBatch() {
		Connection con=JdbcConnectivity.buildConnection();
		Batch b=new Batch();
		System.out.println("Enter Batch Id");
		b.setBid(sc.nextInt());
		System.out.println("Enter Batch Name");
		b.setBname(sc.next());
		System.out.println("Select any faculty to batch Id");
		viewFaculty();
		System.out.println("Enter Faculty Id");
		int id=sc.nextInt();
		
		String sql1="Select*from faculty where fid=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql1);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
			Faculty f=new Faculty();
			f.setFid(rs.getInt(1));
			f.setFname(rs.getString(2));
			Course c=new Course();
			f.setCourse(c);
			c.setCid(rs.getInt(3));
			c.setCname(rs.getString(4));
			b.setFaculty(f);
			String sql2="insert into batch Values(?,?,?,?,?,?)";
			PreparedStatement ps1=con.prepareStatement(sql2);
			
			ps1.setInt(1,b.getBid());
			ps1.setString(2,b.getBname());
			ps1.setInt(3,b.getFaculty().getFid());
			ps1.setString(4,b.getFaculty().getFname());
			ps1.setInt(5,b.getFaculty().getCourse().getCid());
			ps1.setString(6, b.getFaculty().getCourse().getCname());
			ps1.execute();
			}
			else {
				System.out.println("Enter Valid faculty Id To Add");
			}
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
	}
	@Override
	public void viewBatch() {
		Connection con=JdbcConnectivity.buildConnection();
		String sql="select*from batch";
	try {	
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
		System.out.println("Batch Id :"+rs.getInt(1));
		System.out.println("Batch Name :"+rs.getString(2));
	    System.out.println("Faculty Id :"+rs.getInt(3));
	    System.out.println("Faculty Name :"+rs.getString(4));
	    System.out.println("Course Id :"+rs.getInt(5));
	    System.out.println("Course Name :"+rs.getString(6));
		}
	} catch (SQLException e)
	{
		e.printStackTrace();
	}
		
	}
	@Override
	public void addStudent() {
		Connection con=JdbcConnectivity.buildConnection();
		Student s=new Student();
		System.out.println("Enter Student id");
		s.setSid(sc.nextInt());
		System.out.println("Enter Student Name");
		s.setSname(sc.next());
		System.out.println("Select any batch for Student By Id");
		viewBatch();
		System.out.println("Enter Batch Id");
		int id=sc.nextInt();
		String sql="select*from batch where bid=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				Batch b=new Batch();
			    b.setBid(rs.getInt(1));
			    b.setBname(rs.getNString(2));
				Faculty f=new Faculty();
				f.setFid(rs.getInt(3));
			    f.setFname(rs.getString(4));
			   
				Course c=new Course();
				c.setCid(rs.getInt(5));
				c.setCname(rs.getString(6));
				 f.setCourse(c);
			    
			    b.setFaculty(f);
			    s.setBatch(b);
				String sql1="insert into student values(?,?,?,?,?,?,?,?)";
				PreparedStatement ps1 = con.prepareStatement(sql1);
				ps1.setInt(1,s.getSid());
				ps1.setString(2,s.getSname());
				ps1.setInt(3,s.getBatch().getBid());
				ps1.setString(4,s.getBatch().getBname());
				ps1.setInt(5,s.getBatch().getFaculty().getFid());
				ps1.setString(6,s.getBatch().getFaculty().getFname());
				ps1.setInt(7,s.getBatch().getFaculty().getCourse().getCid());
				ps1.setString(8,s.getBatch().getFaculty().getCourse().getCname());
				ps1.execute(); 
			}
				else {
					System.out.println("Enter Valid batch Id To Add");
				}
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	@Override
	public void viewStudent() {
		Connection con=JdbcConnectivity.buildConnection();
		String sql="select*from student";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println("Student Id :"+rs.getInt(1));
				System.out.println("Student Name :"+rs.getString(2));
				System.out.println("Batch Id :"+rs.getInt(3));
				System.out.println("Batch Name :"+rs.getString(4));
				System.out.println("Faculty Id :"+rs.getInt(5));
				System.out.println("Faculty Name :"+rs.getString(6));
				System.out.println("Course Id :"+rs.getInt(7));
				System.out.println("Course Name :"+rs.getString(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
}
