package com.CS425.Logic;

import java.util.Scanner;
import com.CS425.Db.DBMovieDetails;
import com.CS425.bean.UserCCDetails;
import com.CS425.bean.UserDetails;

public class MovieDetails {
		
	public static void main(String args[])
	{
		MovieDetails.viewMovieDetail("Minions",null, null);
		
	}
	
	public static void viewMovieDetail(String movie, UserCCDetails userC,UserDetails userD)
	{	
		Scanner sc=new Scanner(System.in);
		
		DBMovieDetails.getMovieDetails(movie);
		
		
		System.out.println("\nSelect from below options for the "+movie+" movie");
		System.out.println("1. Buy Ticket");
		System.out.println("2. Create Discussion Thread");
		System.out.println("3. Reply on Discussion");
		System.out.println("4. Return to Homepage");
		System.out.println("5. Logout");
		
		int choice=Integer.parseInt(sc.nextLine());
		
		switch(choice)
		{
		case 1:
			buyTicket(movie);
			break;
		case 2:
			
		case 3:
			
		}
		
		
		
	}
	
	public static void buyTicket(String movie)
	{
		MovieDetailSchedule mds= new MovieDetailSchedule();
		mds.viewMovieSchedule(movie);
		
		
	}
	
	
}
