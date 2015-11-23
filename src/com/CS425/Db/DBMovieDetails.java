package com.CS425.Db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DBMovieDetails {

	static ResultSet rs;
	static int result;
	
	

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

	public static void displayMovieSchedule(String movie)
	{
		DBConnections.query = "select s1.schedule_time, s1.availability, s1.price, s1.day, s2.screen_number, s2.capacity, t1.name"
				+ " from Schedule s1 inner join screen s2 on s1.screen_id=s2.screen_id "
				+ "inner join theatre t1 on t1.theatre_id=s2.theatre_id "
				+ "where s2.screen_id IN (Select screen_id from Screen "
				+ "where movie_id IN(Select movie_id from movie where title='"+movie+"'))";
		rs = DBConnections.openDbConnectionForSelect(DBConnections.query);
		try {
			while(rs.next())
			{	
				System.out.println("Theatre Name: "+rs.getString(7));
				System.out.println("ScheduleTime: "+rs.getString(1));
				System.out.println("Availability: "+rs.getString(2));
				System.out.println("Price: "+rs.getString(3));
				System.out.println("Day: "+rs.getString(4));
				System.out.println("Screen Number: "+rs.getString(5));
				System.out.println("Seats Available: "+rs.getString(6));
				
				
				
			}
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the theatre name");
			
			String name=sc.nextLine();
			System.out.println("Enter the time");
			String time=sc.nextLine();
			System.out.println();
			System.out.println("Enter the quantity");
			int quantity=Integer.parseInt(sc.nextLine());
			
			if(name.equals(rs.getString(7)) && time.equals(rs.getString(1)) && quantity<=Integer.parseInt(rs.getString(2)))
			{
				
					System.out.println("Success");
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBConnections.closeDbConnection();
		}
	}
}






