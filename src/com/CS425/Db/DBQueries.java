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


public static void viewProfile(int memberId)
{
	ResultSet rs;
	String str = "select u.name, u.phone, u.address, u.date_of_birth, u.email, u.gender, m.credit_points, m.member_points, m.status, m.role from userregistration u , membership m where u.member_id = m.member_id  and u.member_id =  " + memberId;
	DBConnections.query = str;
	rs = DBConnections.openDbConnectionForSelect(DBConnections.query);
	
	try {
		
		
		System.out.println("----------------------------------------------\n");
		
		while(rs.next())
		{
			String name = rs.getString(1);
			String phone = rs.getString(2);
			String address = rs.getString(3);
			String dob = rs.getString(4);
			String email = rs.getString(5);
			String gender = rs.getString(6);
			int credit_points = rs.getInt(7);
			int member_points = rs.getInt(8);
			String status = rs.getString(9);
			
			System.out.println("Name : " + name);
			System.out.println("Phone Number : " + phone);
			System.out.println("Address : " + address);
			System.out.println("Date of Birth : " + dob.substring(0, 11));
			System.out.println("E-mail : " + email);
			System.out.println("Gender : " + gender);
			System.out.println("Available credit Points : " + credit_points);
			System.out.println("Total points : " + member_points);
			System.out.println("Membership status : " + status);
			
			
		}
			
		System.out.println("----------------------------------------------\n");
				
	} catch (SQLException e) {
		
		e.printStackTrace();
	} finally{
		DBConnections.closeDbConnection();
	}
}


public static void updateProfile(int memberId, int option, String value)
{
	
	String str1 = "update userregistration set phone = '" + value +"' where member_id = " + memberId;
	String str2 = "update userregistration set address = '" + value +"' where member_id = " + memberId;
	
	if(option == 1)
		DBConnections.query = str1;
	if(option ==2)
		DBConnections.query = str2;
	
	
	int ret = DBConnections.openDbConnectionForUpdate(DBConnections.query);
	
	DBConnections.closeDbConnection();
	
	if(ret == 1)
	{
		System.out.println("\nProfile updated\n");
		System.out.println("\nYour Account details :");
		viewProfile(memberId);
	}
			
	
	}

public static void createNewMovieReviewThread(int memberId, String movie, String review)
{
	ResultSet rs;
	int movie_id = 0;
	String str1 = "select movie_id from movie where title = '" + movie +"'";
	String str2 = "insert into review values (seq_review.nextVal, " + memberId + ", 0, '" + review + "', 0)"; 
	 
	DBConnections.query = str1;	
	rs = DBConnections.openDbConnectionForSelect(DBConnections.query);
	
	
	//find movie_id
	try {
		while(rs.next())
		{
			movie_id = rs.getInt(1);			
		}
			
	} catch (SQLException e) {
		
		e.printStackTrace();
	} finally{
		DBConnections.closeDbConnection();
	}
	
	
	//update review table
	DBConnections.query = str2;		
	int ret = DBConnections.openDbConnectionForUpdate(DBConnections.query);	
			
	//update moviereview table
	String str3 = "insert into moviereview (select " + movie_id + ", max(review_id) from review)";
	DBConnections.query = str3;		
	DBConnections.openDbConnectionForUpdate(DBConnections.query);	
	DBConnections.closeDbConnection();
		
	}
}

