package com.CS425.Db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class DBTheatreDetails {
	
	static ResultSet rs;
	static int result;
	
	static ArrayList<String> a1=new ArrayList<String>();
	static ArrayList<String> a2=new ArrayList<String>();
	static ArrayList<String> a3=new ArrayList<String>();

	public static void getTheatreDetails(String theatre){
		DBConnections.query = "select * from theatre where name='"+theatre+"'";
		rs = DBConnections.openDbConnectionForSelect(DBConnections.query);
		try {
			while(rs.next())
			{
				System.out.println("Name: "+rs.getString(2));
				System.out.println("Location: "+rs.getString(3));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBConnections.closeDbConnection();
		}
	}
	
	public static void getTheatreSchedule(String theatre)
	{
		DBConnections.query = "select m1.title,m1.year, m1.genre, m1.description, s1.screen_number, s2.schedule_time, s2.availability, s2.price, s2.day "
				+ "from schedule s2 inner join screen s1 on s1.screen_id=s2.screen_id "
				+ "inner join movie m1 on m1.movie_id=s1.movie_id where s2.screen_id "
				+ "IN (Select screen_id from screen where theatre_id "
				+ "IN (Select theatre_id from Theatre where name='"+theatre+"'))";
		rs = DBConnections.openDbConnectionForSelect(DBConnections.query);
		try {
			while(rs.next())
			{
				System.out.println("Movie Name: "+rs.getString(1));
				System.out.println("Year: "+rs.getString(2));
				System.out.println("Genre: "+rs.getString(3));
				System.out.println("Description: "+rs.getString(4));
				System.out.println("Screen Number: "+rs.getString(5));
				System.out.println("Schedule Time: "+rs.getString(6));
				System.out.println("Availability: "+rs.getString(7));
				System.out.println("Price: "+rs.getString(8));
				System.out.println("Day: "+rs.getString(9));
				
				a1.add(rs.getString(1));
				a2.add(rs.getString(6));
				a3.add(rs.getString(7));
				
			}
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the movie name");
			String name=sc.nextLine();
			System.out.println("Enter the time");
			String time=sc.nextLine();
			System.out.println("Enter the quantity");
			int quantity=sc.nextInt();
			
			Iterator itr=a1.iterator();
			
			while(itr.hasNext())
			{
				if(name.equals(itr.next()) && a2.contains(time))
				{
					System.out.println("Success");
				}
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBConnections.closeDbConnection();
		}
	}
	

}
