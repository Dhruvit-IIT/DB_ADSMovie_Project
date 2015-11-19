package com.CS425.Logic;

import com.CS425.Db.DBMovieDetails;

public class MovieDetailSchedule {
	
	
	public static void viewMovieSchedule(String movie){
		DBMovieDetails.displayMovieSchedule(movie);
	}
	
}
