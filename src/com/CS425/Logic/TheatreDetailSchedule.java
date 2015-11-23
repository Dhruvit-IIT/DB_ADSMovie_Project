package com.CS425.Logic;

import com.CS425.Db.DBTheatreDetails;

public class TheatreDetailSchedule {
	
	public static void viewTheatreSchedule(String theatre)
	{
		DBTheatreDetails.getTheatreSchedule(theatre);
		
		
		
	}
	
	

}
