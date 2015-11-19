package com.CS425.Logic;

import java.util.Scanner;

import com.CS425.Db.FetchData;

public class AppHome {

	Scanner sc;

	public static void main(String args[]){

		AppHome begin = new AppHome();
		begin.displayAppHomePage();
	}

	public void displayAppHomePage(){

		sc = new Scanner(System.in);
		int option;
		String username;
		String pass;
		FetchData data;
		
		while(true){
			System.out.println("*********Welcome to ADSMovies*********\n");
			System.out.println("-----------Menu-------------");
			System.out.println("1. Login\n2. Sign Up\n3. Search Movie\n4. Search Theatre\n5. Queries\n6. Exit");
			System.out.println("----------------------------");
			option = Integer.parseInt(sc.nextLine());

			switch(option){
			case 1:
				System.out.println("Enter user name: ");
				username = sc.nextLine();
				System.out.println("Enter password: ");
				pass = sc.nextLine();
				data = new FetchData();
				if(data.validateUserLogin(username, pass)){
					System.out.println("User is valid");
					continue;
				}// if
				else{
					System.out.println("Username not found or incorrect password.");
					continue;
				} //else
			case 2:
				
			} // switch
		} // while
	}
	
	public boolean validateUserLogin(String username, String pass){
		return true;
	}
}
