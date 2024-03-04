package com.client;

import java.util.Scanner;
import com.service.Cjc;
import com.serviceimpl.KarveNagar;

public class Test {
	public static void main(String[] args) 
		
	
	{
		Scanner sc=new Scanner(System.in);
		Cjc c=new KarveNagar();
		System.out.println("Welcome");
		while(true)
		{
		System.out.println("select any choice\n"
				+ "1.Add Course\n"
				+ "2.View Course\n"
				+ "3.Add Faculty\n"
				+ "4.View Faculty\n"
				+ "5.Add Batch\n"
				+ "6.View Batch\n"
				+ "7.Add Student\n"
				+ "8.View Student\n"
				+ "9.Exit\n");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:c.addCourse();
		       break;
		case 2:c.viewcourse();
		       break;
		case 3:c.addFaculty();
		       break;
		case 4:c.viewFaculty();
		       break;
		case 5:c.addBatch();
	           break;
	    case 6:c.viewBatch();
	           break;
	    case 7:c.addStudent();
	           break;
	    case 8:c.viewStudent();
	           break;
	    case 9:System.exit(0);
		
		}
	}
	
	}
} 
