package com.CS425.Logic;

import java.util.Scanner;

public class OwnerHome {

	static int option;

	public static void viewOwnerHome()
	{
		Scanner sc=new Scanner(System.in);
		StaffDetails staff=new StaffDetails();
		boolean flag=true;

		while(flag){
			System.out.println("*******  Welcome Owner**************");
			System.out.println("----------------------------------------------");
			System.out.println("\nPlease enter option number from below menu : \n");
			System.out.println("----------------------------------------------");
			System.out.println("1 - Hire Staff");
			System.out.println("2 - Set Staff Schedule");
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
				flag=userDetails();
				break;
			}
			case 5:
			{
				flag=viewAllTables();
				break;
			}
			case 6:
			{
				flag=addMovieToTheatre();
				break;
			}
			case 7:
			{
				flag=setMovieSchedule();
				break;
			}
			case 8:
			{
				System.out.println("underCinstruction");
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

	private static boolean setMovieSchedule() {
		return false;
		// TODO Auto-generated method stub

	}

	private static boolean addMovieToTheatre() {
		return false;
		// TODO Auto-generated method stub

	}

	private static boolean viewAllTables() {
		return false;
		// TODO Auto-generated method stub

	}

	private static boolean userDetails() {
		return false;
		// TODO Auto-generated method stub

	}

}
