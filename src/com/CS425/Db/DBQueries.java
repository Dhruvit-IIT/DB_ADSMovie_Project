package com.CS425.Db;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBQueries
{

	
public static void movieRecommendations(int memberId)
{
	ResultSet rs1, rs2;
	String str1 = "select title from movie where now_showing = 1 and genre in (select movie.genre from purchase, orderdetails, movie where purchase.member_id = '" + memberId + "' AND purchase.order_id = orderdetails.order_id AND orderdetails.movie_id = movie.movie_id)";
	String str2 = "select title from movie where now_showing = 1 and rating > (select avg(rating) from movie where now_showing = 1) and rownum <= 5 order by rating desc";
	DBConnections.query = str1;
	rs1 = DBConnections.openDbConnectionForSelect(DBConnections.query);
	try {
		int count = 0;
		System.out.println("Below are some movies recommended for you");
		System.out.println("----------------------------------------------\n");
		
		while(rs1.next())
		{
			String in = rs1.getString(1);
			System.out.println(in);
			count++;
		}
		if(count == 0)
		{
			
			//DBConnections.closeDbConnection();
			DBConnections.query = str2;
			rs2 = DBConnections.openDbConnectionForSelect(DBConnections.query);
			while(rs2.next())
			{
				String in2 = rs2.getString(1);
				System.out.println(in2);
				
			}
			
		}
	
		System.out.println("\n");
				
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally{
		DBConnections.closeDbConnection();
	}
	
}


}
