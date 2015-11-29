package com.CS425.Logic;

import java.util.Scanner;

import com.CS425.bean.StaffDetails;

public class OwnerHome {

	static int option;

	public static void viewOwnerHome(StaffDetails staffD)
	{
		Scanner sc=new Scanner(System.in);
		StaffProcessing staffP = new StaffProcessing();
		boolean flag=true;

		while(flag){
			System.out.println("*************Welcome " + staffD.getName() + "**************");
			System.out.println("----------------------------------------------");
			System.out.println("\nPlease enter option number from below menu : \n");
			System.out.println("----------------------------------------------");
			System.out.println("1 - Hire Staff");
			System.out.println("2 - Manage Staff Schedule");
			System.out.println("3 - Set Credit Points Policy");
			System.out.println("4 - View Registered USers Details");
			System.out.println("5 - View All Tables");
			System.out.println("6 - Add Movie to the Theatre");
			System.out.println("7 - Set Movie Schedule");
			System.out.println("8 - Delegate Responsibilities");
			System.out.println("9 - Logout");

			option=Integer.parseInt(sc.nextLine());
			switch(option)
			{
			case 1: 
			{

				flag=staffP.hireStaff(staffD);
				break;
			}
			case 2:
			{
				flag=staffP.setStaffSchedule(staffD);
				break;
			}
			case 3:
			{
				System.out.println("Under construction");
				break;
			}
			case 4:
			{
				
				break;
			}
			case 5:
			{
				
				break;
			}
			case 6:
			{
				break;
			}
			case 7:
			{
				break;
			}
			case 8:
			{
				
			}
			case 9:
				flag = false;
				break;
			default:
				System.out.println("Please enter right option");
				break;
			}//switch
		}//while
	}//method
}
