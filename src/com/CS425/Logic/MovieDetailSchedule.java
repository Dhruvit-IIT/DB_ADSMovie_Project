package com.CS425.Logic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.CS425.Db.DBMovieDetails;
import com.CS425.bean.TheatreSchedule;
import com.CS425.bean.UserCCDetails;
import com.CS425.bean.UserDetails;

public class MovieDetailSchedule {

	Scanner sc=new Scanner(System.in);

	public static void viewMovieSchedule(String movie, UserCCDetails userC, UserDetails userD){

		String name;
		String time;
		int quantity;
		int scheduleId;
		String day;
		ArrayList<TheatreSchedule> theatreSchedule=new ArrayList<TheatreSchedule>();
		Scanner sc=new Scanner(System.in);
		theatreSchedule=DBMovieDetails.displayMovieSchedule(movie);	
		TheatreSchedule ts;
		Iterator<TheatreSchedule> theatreItr=theatreSchedule.iterator();
		while(theatreItr.hasNext())
		{
			ts=theatreItr.next();
			System.out.println("Theatre Name: "+ts.getTheatreName());
			//System.out.println("Availability: "+ts.getAvailability());
			System.out.println("Screen Number: "+ts.getScreenNumber());
			System.out.println("Price: "+ts.getPrice());
			System.out.println("Schedule: "+ts.getScheduleTime());
			System.out.println("Day: "+ts.getDay());
			System.out.println("Total Seats Available: "+ts.getSeatsAvailable());


		}

		System.out.println("Enter the theatre Name");
		name=sc.nextLine();
		System.out.println("Enter time:");
		time=sc.nextLine();
		System.out.println("Enter quantity");
		quantity=Integer.parseInt(sc.nextLine());
		System.out.println("Enter the day");
		day=sc.nextLine();


		for(TheatreSchedule temp: theatreSchedule)
		{
			if (temp.getTheatreName().equals(name) && temp.getScheduleTime().equals(time) && temp.getDay().equals(day))
			{
				MovieDetailSchedule.purchaseTicket(movie, quantity, day, userC, userD );
			}
			
			
			
		 }//forEach
	}

	private static void purchaseTicket(String movie, int quantity, String day, UserCCDetails userC, UserDetails userD ) {
		// TODO Auto-generated method stub
		System.out.println("");
		//To be dContinued
		Scanner sc=new Scanner(System.in); 
		
		System.out.println("Do you want to redeem your credit card points(1. Yes/2. No)");
		int choice=sc.nextInt();
		
		if(choice==1)
		{
			
		}
		
		
	}



}
