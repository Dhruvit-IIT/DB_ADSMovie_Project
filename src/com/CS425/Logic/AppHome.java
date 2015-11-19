package com.CS425.Logic;

import java.io.Console;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.CS425.Db.FetchData;
import com.CS425.bean.UserCCDetails;
import com.CS425.bean.UserDetails;

public class AppHome {

	public static void main(String args[]){

		AppHome begin = new AppHome();
		begin.displayAppHomePage();
	}

	public void displayAppHomePage(){

		Scanner sc = new Scanner(System.in);
		boolean breakWhile = false;
		int option;
		String email, pass, movie, theatre;
		FetchData data =  new FetchData();;
		UserDetails userD;
		UserCCDetails userCC;
		//TheatreDetails td;
		//MovieDetails tm;

		while(!breakWhile){
			System.out.println("*********Welcome to ADSMovies*********\n");
			System.out.println("-----------Menu-------------");
			System.out.println("1. Login\n2. Sign Up\n3. Search Movie\n4. Search Theatre\n5. Queries\n6. Exit");
			System.out.println("----------------------------");
			option = Integer.parseInt(sc.nextLine());

			switch(option){
			case 1:
				while(true){
					System.out.print("Enter email Id: ");
					email = sc.nextLine();
					System.out.print("Enter password: ");
					pass = sc.nextLine();
					if(data.validateUserLogin(email, pass)){
						userD = data.getUserDetails(email);
						userCC = data.getUserCCDetails();

						/* call user home page function. Pass userD and userCC*/
						break;
					}// if
					else{
						System.out.println("**Username not found or incorrect password.**\n");
					} //else
				} //while
				break;
			case 2:
				System.out.println("#SIGN UP#\n");
				signUpUser(sc, data);
				break;
			case 3:
				while(true){
					System.out.println("Enter Movie name: ");
					movie = sc.nextLine();
					if(data.validateMovie(movie)){
						//tm = new MovieDetails();
						//tm.viewMovieDetails(movie);
						break;
					}// if
					else
						System.out.println("**Movie not found.**\n");
				} //while
				break;
			case 4:
				while(true){
					System.out.println("Enter Theatre name: ");
					theatre = sc.nextLine();
					if(data.validateTheatre(theatre)){
						//td = new TheatreDetails();
						//td.viewTheatreDetails(theatre);
						break;
					}// if
					else
						System.out.println("**Theatre not found.**\n");
				} //while
				break;
			case 5:
				/* Queries result will come here*/
				break;
			case 6:
				System.out.println("Good Bye!!!!");
				breakWhile = true;
				sc.close();
				break;
			} // switch
		} // while
	}

	private void signUpUser(Scanner sc, FetchData data) {

		boolean dbSuccess = false;
		while(!dbSuccess){
			UserDetails user;
			UserCCDetails userCC;

			System.out.print("Name: ");
			String name=sc.nextLine();

			System.out.print("Phone Number: ");
			String phone=sc.nextLine();

			System.out.print("Address: ");
			String address=sc.nextLine();

			System.out.print("Date of Birth(MM-DD-YYYY)");
			String dob=sc.nextLine();
			DateFormat format = new SimpleDateFormat("MM-DD-YYYY", Locale.ENGLISH);
			Date date = null;
			try {
				date = (Date) format.parse(dob);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.print("Email: ");
			String email=sc.nextLine();

			System.out.print("Gender (Male/Female): ");
			String gender=sc.nextLine();

			System.out.println("\n** Please enter your credit card details **");

			System.out.print("Credit Card Type (MasterCard/Visa/AmericanExpress): ");
			String cardType = sc.nextLine();

			System.out.print("Card Number: ");
			String cardNumber = sc.nextLine();

			System.out.print("Name on Card: ");
			String nameOnCard = sc.nextLine();

			System.out.print("Expiry: ");
			String expiry = sc.nextLine();

			System.out.print("Password: ");
			String password = sc.nextLine();

			user = new UserDetails(name, address, phone, date, email, gender, 0, 0, "Silver", "Non-staff");
			userCC = new UserCCDetails(cardType, cardNumber, expiry, nameOnCard);
			
			if(data.insertUserDetails(user, userCC) && data.insertUserLoginDetails(email, password)){
				System.out.println("User registered succesfully. Redirecting to home page.");
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dbSuccess = true;
			}
			else{
				System.out.println("Error while registering user. Please enter details again.");
			}
		}// while
	}// method
}