package com.CS425.Logic;

import java.util.ArrayList;
import java.util.Scanner;

import com.CS425.Db.DBMovieDetails;
import com.CS425.Db.DBTheatreDetails;
import com.CS425.bean.MovieSchedule;
import com.CS425.bean.UserCCDetails;
import com.CS425.bean.UserDetails;

public class TheatreDetails {

	public static void viewTheatreDetails(String theatre, UserDetails userD, UserCCDetails userCC)
	{
		Scanner sc=new Scanner(System.in);
		DBTheatreDetails.getTheatreDetails(theatre);

		while(true){
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
				if(userD == null)
					buyTicketGuest(theatre);
				buyTicketUser(theatre, userD, userCC, sc);
			}// Switch
		}// While
	}

	private static void buyTicketGuest(String theatre) {
		// TODO Auto-generated method stub

	}

	public static void buyTicketUser(String theatre, UserDetails userD, UserCCDetails userCC, Scanner sc)
	{
		ArrayList<MovieSchedule> mScheduleList = new ArrayList<MovieSchedule>(); 
		MovieSchedule selectedMovie = null;
		mScheduleList = DBTheatreDetails.getTheatreSchedule(theatre);
		
		if(mScheduleList == null){
			System.err.println("**No movies screened in the theatre. Select another theatre.***");
			return;
		}

		System.out.println("\nEnter following details to purchase ticket:");
		System.out.print("Enter movie name:");
		String movieName = sc.nextLine();
		System.out.print("Enter day: ");
		String day = sc.nextLine();
		System.out.print("Enter Schedule Time: ");
		String time = sc.nextLine();
		System.out.print("Enter quantity: ");
		int quantity = Integer.parseInt(sc.nextLine());

		for(MovieSchedule temp : mScheduleList){
			if(temp.getMovieName().equals(movieName) && temp.getScheduleTime().equals(time) && temp.getDay().equals(day)){
				selectedMovie = temp;
				break;
			}
			else{
				System.out.println("Invalid details.");
				return;
			}
		}// for
		System.out.print("**Do you want to redeem your membership points?**\n1. Yes\n2. No");
		String option = sc.nextLine();
		if(option.equals("1")){
			if(!processPurchase(true, selectedMovie, quantity, userD, userCC)){
				System.out.println("***Sorry!! Ticket not purchased.***");
				return;
			}// if
		}// if(option == "1")
		if(option.equals("2"))
			if(!processPurchase(false, selectedMovie, quantity, userD, userCC)){
				System.out.println("***Sorry!! Ticket not purchased.***");
				return;
			}// if
		else{
			System.out.println("Invalid option.");
			return;
		}//else
	}// function

	public static boolean processPurchase(boolean redeemPoints, MovieSchedule selectedMovie, int quantity, UserDetails userD, UserCCDetails userCC) {
		// TODO Auto-generated method stub
		System.out.println("**Processing purchase**");
		Scanner sc=new Scanner(System.in);
		if(redeemPoints){
			if(userD.getCreditPoints() < selectedMovie.getPrice()){
				System.out.println("Insufficient credit points. Do you wanna purchase via credit card.\n1. Yes\n2. No");
				if(sc.nextLine() == "2")
					return false;
				else
					return DBTheatreDetails.purchaseTicketViaCC(selectedMovie, quantity, userD, userCC);
			}// if
		}// if(redeemPoints) 
		return DBTheatreDetails.purchaseTicketViaCC(selectedMovie, quantity, userD, userCC);
	}// function
}
