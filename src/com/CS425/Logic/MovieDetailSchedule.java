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
			System.out.println("Total Seats: "+ts.getSeatsAvailable());
			
			

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
				MovieDetailSchedule.purchaseTicket(movie, quantity, day, userC, userD, temp );
			}
			
			
			
		 }//forEach
	}

	private static void purchaseTicket(String movie, int quantity, String day, UserCCDetails userC, UserDetails userD, TheatreSchedule temp ) {
		// TODO Auto-generated method stub
		System.out.println("");
		//To be dContinued
		Scanner sc=new Scanner(System.in); 
		
		System.out.println("Do you want to redeem your credit points(1. Yes/2. No)");
		int choice=sc.nextInt();
		
		if(choice==2)
		{
			DBMovieDetails.purchaseTicket(movie,quantity,day,userC,userD,temp);
			
		//	DBMovieDetails.invoice(movie,quantity,day,userC,userD,temp);
			
			
		}
		else
		{
			if((userD.getCreditPoints()* 0.01)> (temp.getPrice()*quantity))
			{
				DBMovieDetails.purchaseTicketViaCreditPoints(movie,quantity,day,userC,userD,temp);
			}
			else
			{
				System.out.println("You have insufficient credit points to buy the tickets");
			}
			
			//MovieInvoice.printInvoice(movie,quantity,day,userC,userD,temp);
			
			
		}	
	}
}
