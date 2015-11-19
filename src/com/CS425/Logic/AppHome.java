package com.CS425.Logic;

import java.util.Scanner;

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
			case 2:
				System.out.println("#SIGN UP#\n");
			case 3:
				while(true){
					System.out.println("Enter Movie name: ");
					movie = sc.nextLine();
					if(data.validateMovie(movie)){
						/*Pass movie and userD to Sahil*/
						break;
					}// if
					else
						System.out.println("**Movie not found.**\n");
				} //while
			case 4:
				while(true){
					System.out.println("Enter Theatre name: ");
					theatre = sc.nextLine();
					if(data.validateTheatre(theatre)){
						/*Pass theatre and userD to Sahil*/
						break;
					}// if
					else
						System.out.println("**Theatre not found.**\n");
				} //while
			case 5:
				/* Queries result will come here*/
			case 6:
				System.out.println("Good Bye!!!!");
				breakWhile = true;
				sc.close();
				break;
			} // switch
		} // while
	}
}