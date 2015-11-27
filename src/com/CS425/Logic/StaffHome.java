package com.CS425.Logic;

import java.util.Scanner;

public class StaffHome {
	
	Scanner sc=new Scanner(System.in);
	StaffDetails staff=new StaffDetails();
	boolean flag=true;
	int option;
	
	public void viewStaff()
	{
		while(flag){
			System.out.println("*******  Welcome **************");
			System.out.println("----------------------------------------------");
			System.out.println("\nPlease enter option number from below menu : \n");
			System.out.println("----------------------------------------------");
			System.out.println("1 - View Profile");
			System.out.println("2 - View Schedule");
			System.out.println("3 - Logout");

			option=Integer.parseInt(sc.nextLine());
			switch(option)
			{
			case 1:
				viewProfile();
				break;
			
			case 2:
				viewSchedule();
				break;
			
			case 3:
				flag=false;
				break;
			
			default:
				System.out.println("Please select the right choice");
				break;
			}

	}
	}

	private void viewSchedule() {
		// TODO Auto-generated method stub
		
	}

	private void viewProfile() {
		// TODO Auto-generated method stub
		
	}
}
