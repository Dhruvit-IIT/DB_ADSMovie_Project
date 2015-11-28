package com.CS425.Logic;

import java.util.Scanner;

public class StaffHome {
	
	static Scanner sc=new Scanner(System.in);
	static boolean flag=true;
	static int option;
	
	public static void viewStaff()
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

	private static void viewSchedule() {
		// TODO Auto-generated method stub
		
	}

	private static void viewProfile() {
		// TODO Auto-generated method stub
		
	}
}
