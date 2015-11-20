package com.CS425.Logic;

import java.util.Scanner;

import com.CS425.Db.DBMovieDetails;
import com.CS425.Db.DBTheatreDetails;

public class TheatreDetails {


	public static void main(String args[])
	{
		viewTheatreDetails("Ice Chatham Theaters");
	}

	public static void viewTheatreDetails(String theatre)
	{
		Scanner sc=new Scanner(System.in);

		DBTheatreDetails.getTheatreDetails(theatre);



		System.out.println("\nSelect from below options for the "+theatre+" Theatre");
		System.out.println("1. Buy Ticket");
		System.out.println("2. Create Discussion Thread");
		System.out.println("3. Reply on Discussion");
		System.out.println("4. Return to Homepage");
		System.out.println("5. Logout");

		int choice=Integer.parseInt(sc.nextLine());

		switch(choice)
		{
		case 1:
			buyTicket();

		}
	}

	public static void buyTicket()
	{
		TheatreDetailSchedule tds=new TheatreDetailSchedule();
		tds.viewTheatreSchedule();
	}

}
