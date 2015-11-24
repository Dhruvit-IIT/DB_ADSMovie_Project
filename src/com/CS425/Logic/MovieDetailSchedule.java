package com.CS425.Logic;

import java.util.Scanner;

import com.CS425.Db.DBMovieDetails;

public class MovieDetailSchedule {
	
	Scanner sc=new Scanner(System.in);
	
	public static void viewMovieSchedule(String movie){
		Scanner sc=new Scanner(System.in);
		DBMovieDetails.displayMovieSchedule(movie);
		
		System.out.println("Enter the theatre name");
		String name=sc.nextLine();
		
		
		
	}
	
}
