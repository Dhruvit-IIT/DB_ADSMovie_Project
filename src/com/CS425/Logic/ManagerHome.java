package com.CS425.Logic;

import java.util.Scanner;

import com.CS425.bean.StaffDetails;

public class ManagerHome {
	static Scanner sc=new Scanner(System.in);
	static StaffProcessing staffP = new StaffProcessing();
	static boolean flag=true;
	static int option;


	public static void viewManagerHome(StaffDetails staffD){


		while(flag){
			System.out.println("*************Welcome " + staffD.getName() + "**************");
			System.out.println("----------------------------------------------");
			System.out.println("\nPlease enter option number from below menu : \n");
			System.out.println("----------------------------------------------");
			System.out.println("1 - Hire Staff");
			System.out.println("2 - Manage Staff Schedule");
			System.out.println("3 - Set Credit Points Policy");
			System.out.println("4 - Logout");

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
				flag=staffP.setStaffSchedule();
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
