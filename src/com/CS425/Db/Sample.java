package com.CS425.Db;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Sample {
	
	static ResultSet rs;
	static int result;
	
	public static void main(String args[]){
		Sample.getAllMovies();
	}
	
	public static void getAllMovies(){
		
		DBConnections.query = "select title from movie where now_showing = 1 and genre in (select movie.genre from purchase, orderdetails, movie where purchase.member_id = '" + 1001 + "' AND purchase.order_id = orderdetails.order_id AND orderdetails.movie_id = movie.movie_id)";
		rs = DBConnections.openDbConnectionForSelect(DBConnections.query);
		try {
			
			while(rs.next())
			{
				System.out.println(" I am in while");
				String in = rs.getString(1);
				if(in == null || in == "" || in == " ")
				{
					System.out.println(" I am in if");
				}
			}
			System.out.println(" I am outside while");	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBConnections.closeDbConnection();
		}
	}
}
