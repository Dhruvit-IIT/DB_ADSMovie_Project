package com.CS425.Db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.*;

import javax.swing.text.html.HTMLDocument.Iterator;

import com.CS425.Logic.MovieDetailSchedule;
import com.CS425.bean.OrderDetails;
import com.CS425.bean.TheatreSchedule;

public class DBMovieDetails {

	static ResultSet rs;
	static int result;
	
	static ArrayList<String> theatreName= new ArrayList<String>();
	static ArrayList<String> a2= new ArrayList<String>();
	static ArrayList<String> a3= new ArrayList<String>();

	public static void getMovieDetails(String movie){
		DBConnections.query = "select * from movie where title='"+movie+"'";
		rs = DBConnections.openDbConnectionForSelect(DBConnections.query);
		try {
			while(rs.next())
			{
				System.out.println("Name: "+rs.getString(2));
				System.out.println("Year: "+rs.getString(3));
				System.out.println("Genre: "+rs.getString(4));
				System.out.println("Description: "+rs.getString(5));
				System.out.println("Director: "+rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBConnections.closeDbConnection();
		}
	}

	public static ArrayList<TheatreSchedule> displayMovieSchedule(String movie)
	{	
		ArrayList<TheatreSchedule> theatreDetails= new ArrayList<TheatreSchedule>();
		TheatreSchedule theatreSchedule;
		DBConnections.query = "select s1.schedule_time, s1.availability, s1.price, s1.day, s2.screen_number, s2.capacity, t1.name, s1.schedule_id"
				+ " from Schedule s1 inner join screen s2 on s1.screen_id=s2.screen_id "
				+ "inner join theatre t1 on t1.theatre_id=s2.theatre_id "
				+ "where s2.screen_id IN (Select screen_id from Screen "
				+ "where movie_id IN(Select movie_id from movie where title='"+movie+"'))";
		rs = DBConnections.openDbConnectionForSelect(DBConnections.query);
		try {
			while(rs.next())
			{	
				
				theatreSchedule=new TheatreSchedule(rs.getString(7), rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(8));
				
				theatreDetails.add(theatreSchedule);
				
				
				
				
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBConnections.closeDbConnection();
		}
		return theatreDetails;
	}
}






