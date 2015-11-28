package com.CS425.Logic;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.CS425.Db.DBStaffProcessing;
import com.CS425.bean.StaffDetails;

public class StaffProcessing {

	Scanner sc = new Scanner(System.in);
	DBStaffProcessing dbstaff = new DBStaffProcessing();

	public boolean setStaffSchedule() {
		
		boolean exit = true;
		   int staff_id;
		   String date;
		   String startTime;
		   String endTime;
		   
		   while(exit)
		   {
			   System.out.println("\n**Staff Schedule Manager**");
			   System.out.println("Please enter your choice:");
			   System.out.println("1 - Add Schedule :");
			   System.out.println("2 - Update Schedule :");
			   System.out.println("3 - Exit :");
			   String in = sc.nextLine();
			   switch (in)
			   {
			   case "1" :
				   System.out.print("Enter the staff ID: ");
				   staff_id = Integer.parseInt(sc.nextLine());
				   System.out.print("Enter date in yyyy-mm-dd : ");
				   date = sc.nextLine();
				   System.out.print("Enter the start time of the shift in 24hrs  e.g 13.30");
				   startTime = sc.nextLine();
				   System.out.print("Enter the end time of the shift in 24hrs  e.g 20.30");
				   endTime = sc.nextLine();
				  
				   //date = date + " 00:00:00";
				   //addSchedule(staff_id, date, startTime, endTime);
				   break;
			
			   case "2" :
				   System.out.printf("Enter the staff ID: ");
				   staff_id = Integer.parseInt(sc.nextLine());
				   //getSchedule(staff_id);
				   System.out.println("Enter date in yyyy-mm-dd for which schedule needs to be updated");
				   date = sc.nextLine();
				   System.out.println("Enter the start time of the shift in 24hrs  e.g 13.30");
				   startTime = sc.nextLine();
				   System.out.println("Enter the end time of the shift in 24hrs  e.g 20.30");
				   endTime = sc.nextLine();
				   //updateSchedule(staff_id, date, startTime, endTime);
					
				   break;	   
			   case "3":
				   exit = false;
				   break;
			   default:
				   System.out.println("Please enter valid input");
				   break;
			   }		    
		   }
		return exit;  
	}

	public boolean hireStaff(StaffDetails staff) {

		boolean dbSuccess = false;
		while(!dbSuccess){
			StaffDetails staffD = new StaffDetails();
			if(staff.getStaffId() == 1000)
				System.out.println("\n*-----Staff Hiring Form for AMC group of Theaters-----*\n");
			else
				System.out.println("\n*-----Staff Hiring Form-----*\n"); 

			System.out.print("Full Name: ");
			staffD.setName(sc.nextLine());

			System.out.print("Address: ");
			staffD.setAddress(sc.nextLine());

			System.out.print("Phone No: ");
			staffD.setPhone(sc.nextLine());

			System.out.print("Email: ");
			staffD.setEmail(sc.nextLine());

			System.out.print("9-digit SSN: ");
			staffD.setSsn(sc.nextLine());

			System.out.print("Date of joining(MM-DD-YYYY): ");
			staffD.setDateOfJoining(sc.nextLine());

			boolean done = false;
			while(!done){
				System.out.println("Select from following work category: ");
				System.out.println("\ta. Cleaning");
				System.out.println("\tb. Ticketing");
				System.out.println("\tc. Snack Provider");
				System.out.println("\td. Security");
				if(staff.getStaffId() == 1000)
					System.out.println("\te. Manager");

				switch(sc.nextLine().toLowerCase()){
				case "a":
					staffD.setDescId(1015);
					done = true;
					break;
				case "b":
					staffD.setDescId(1014);
					done = true;
					break;
				case "c":
					staffD.setDescId(1013);
					done = true;
					break;
				case "d":
					staffD.setDescId(1012);
					done = true;
					break;
				case "e":
					staffD.setDescId(1011);
					done = true;
					break;
				default:
					System.out.println("Invalid option. Enter again.\n");
				}// switch
			}// while

			if(staff.getStaffId() == 1000){
				ArrayList<String> allTheaterList = new ArrayList<String>();
				allTheaterList = dbstaff.fetchTheatreList();
				System.out.println("Select 'Location Id' following work locations: ");
				for(String temp : allTheaterList)
					System.out.println("\t" + temp);
				System.out.print("Work Location Id: ");
				staffD.setTheatreId(Integer.parseInt(sc.nextLine()));
			}
			else
				staffD.setTheatreId(staff.getTheatreId());
			
			System.out.println("Confirm.\n1. Yes\n2. No");
			if(sc.nextLine().equalsIgnoreCase("No")){
				System.out.println("Action cancelled");
				return true;
			}
			
			if(dbstaff.insertStaffToDb(staffD)){
				System.out.println("Staff registered succesfully. Redirecting to home page.\n");
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				dbSuccess = true;
			}// if
			else{
				System.out.println("Error while registering user. Please enter details again.");
			}// else
		}// while
		return true;
	}
}