package com.client;

import java.util.Scanner;

import com.service.Rbi;
import com.serviceImplemaintation.Sbi;

public class Test {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Rbi bank=new Sbi();
		System.out.println("Welcome to SBI");
		while(true) {
			 System.out.println(" Select any choice no.\n"
			 		+ " 1.Create New Account \n"
			 		+ " 2.Check Account Details \n"
			 		+ " 3.Check Account Balance \n"
			 		+ " 4.Deposite Ammount \n"
			 		+ " 5.Withdrowl Ammount \n"
			 		+ " 6.Exit");
			 int choice=sc.nextInt();
			 
			 switch(choice){
			 case 1:
			 {  
				 bank.createAccount();
				 break;
			 }
			 case 2:
			 {
				 bank.displayAccountDetails();
				 break;
			 }
			 case 3:
			 {
				 bank.checkAccountBalance();
				 break;
			 }
			 case 4:
			 {
				 bank.depositAmmount();
				 break;
			 }
			 case 5:
			 {
				 bank.withdrowAmmount();
				 break;
			 }
			 case 6:
			 {
				 System.exit(0);
			 }
			 }
			 }
			
		}

	


}
