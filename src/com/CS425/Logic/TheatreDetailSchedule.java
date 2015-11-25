package com.CS425.Logic;

import java.util.ArrayList;

import com.CS425.Db.DBTheatreDetails;
import com.CS425.bean.MovieSchedule;

public class TheatreDetailSchedule {
	
	public static void viewTheatreSchedule(String theatre)
	{	
		ArrayList<MovieSchedule> mScheduleList = new ArrayList<MovieSchedule>();
		mScheduleList = DBTheatreDetails.getTheatreSchedule(theatre);	
	}
}
