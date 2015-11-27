package com.CS425.Logic;

import java.util.Scanner;

public class ManagerHome {
	Scanner sc=new Scanner(System.in);
	StaffDetails staff=new StaffDetails();
	boolean flag=true;
	int option;


	public void viewManagerHome(){


		while(flag){
			System.out.println("*******  Welcome **************");
			System.out.println("----------------------------------------------");
			System.out.println("\nPlease enter option number from below menu : \n");
			System.out.println("----------------------------------------------");
			System.out.println("1 - Hire Staff");
			System.out.println("2 - Set Staff Schedule");
			System.out.println("3 - Set Credit Points Policy");
			System.out.println("4 - Logout");

			option=Integer.parseInt(sc.nextLine());



			switch(option)
			{
			case 1: 
			{

				flag=staff.hireStaff();
				break;
			}
			case 2:
			{
				flag=staff.setStaffSchedule();
				break;
			}
			case 3:
			{
				System.out.println("Under construction");
				break;
			}
			case 4:
			{
				flag=false;
				break;
			}
			default:
				System.out.println("Please select the right oprion");
				break;
			}
		}
	}
}
