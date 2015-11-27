package com.CS425.Db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.*;

import javax.swing.text.html.HTMLDocument.Iterator;

import com.CS425.Logic.MovieDetailSchedule;
import com.CS425.bean.OrderDetails;
import com.CS425.bean.TheatreSchedule;
import com.CS425.bean.UserCCDetails;
import com.CS425.bean.UserDetails;

public class DBMovieDetails {

	static ResultSet rs;
	static int result;

	static ArrayList<String> theatreName= new ArrayList<String>();
	static ArrayList<String> a2= new ArrayList<String>();
	static ArrayList<String> a3= new ArrayList<String>();

	public static void getMovieDetails(String movie){
		DBConnections.query = "select m1.title, m1.year, m1.genre, m1.description, m1.director, s1.name from movie m1 inner join starin s1 on m1.movie_id=s1.movie_id where m1.movie_id in(Select movie_id from movie where title='"+movie+"')";
		rs = DBConnections.openDbConnectionForSelect(DBConnections.query);
		try {
			while(rs.next())
			{
				System.out.println("Name: "+rs.getString(1));
				System.out.println("Year: "+rs.getString(2));
				System.out.println("Genre: "+rs.getString(3));
				System.out.println("Description: "+rs.getString(4));
				System.out.println("Director: "+rs.getString(5));
				System.out.println("Stars: "+rs.getString(6));
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
		DBConnections.query = "select s1.schedule_time, s1.availability, s1.price, s1.day, s2.screen_number, s2.capacity, t1.name, s1.schedule_id, s1.availability"
				+ " from Schedule s1 inner join screen s2 on s1.screen_id=s2.screen_id "
				+ "inner join theatre t1 on t1.theatre_id=s2.theatre_id "
				+ "where s2.screen_id IN (Select screen_id from Screen "
				+ "where movie_id IN(Select movie_id from movie where title='"+movie+"'))";
		rs = DBConnections.openDbConnectionForSelect(DBConnections.query);
		try {
			while(rs.next())
			{	

				theatreSchedule=new TheatreSchedule(rs.getString(7), rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(8), rs.getInt(9));

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

	public static void purchaseTicket(String movie, int quantity, String day, UserCCDetails userC, UserDetails userD, TheatreSchedule temp) 
	{
		// TODO Auto-generated method stub
		int movie_id = 0;
		int order_id=0;

		ResultSet rs1 = null;
		ResultSet rs2=null;
		
		
		
		String memberStatus=userD.getStatus();
		int creditPoints = 0;
		switch(memberStatus)
		{
		case "Silver":
			creditPoints=(int) ((quantity * temp.getPrice())*0.01);
			break;
		case "Gold":
			creditPoints=(int) ((quantity * temp.getPrice())*0.02);
			break;
		case "Platinum":
			creditPoints= (int) ((quantity * temp.getPrice())*0.05);
			break;
			
		}
		
		DBConnections.query = "update Membership set credit_points = credit_points + " + creditPoints + ", member_points= member_points+ "+quantity*temp.getPrice()+"where member_id = " + userD.getMemberId();
		int result2 = DBConnections.openDbConnectionForUpdate(DBConnections.query);
		DBConnections.closeDbConnection();
		
		
		

		DBConnections.query="Select movie_id from movie where title='"+movie+"'";
		rs = DBConnections.openDbConnectionForSelect(DBConnections.query);

		try {
			while(rs.next())
			{
				movie_id=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBConnections.closeDbConnection();
		}
		
		DBConnections.query="insert into orderdetails values (seq_order.nextval, "+quantity+", "+userC.getCardNumber()+", "+temp.getScheduleId() + ", " +movie_id+ ",sysdate)";

		//System.out.println(DBConnections.query);
		//To be continued

		int result=DBConnections.openDbConnectionForUpdate(DBConnections.query);



		DBConnections.query="select order_id from orderdetails where card_no = "+userC.getCardNumber()+" and schedule_id = " +temp.getScheduleId()+" and rownum=1 order by order_id";

		rs1=DBConnections.openDbConnectionForSelect(DBConnections.query);
		try {
			while(rs1.next())
			{
				order_id=rs1.getInt(1);
				//System.out.println(order_id);
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBConnections.closeDbConnection();
		}

		
		if(result==1)
		{
			DBConnections.query="insert into purchase values (" + userD.getMemberId()+", " + order_id +")";

			int purchased=DBConnections.openDbConnectionForUpdate(DBConnections.query);

			if(purchased==1)
			{
				DBConnections.query="update schedule set availability = availability - "+ quantity +" where schedule_id=" + temp.getScheduleId();
				result = DBConnections.openDbConnectionForUpdate(DBConnections.query);
				DBConnections.closeDbConnection();
			}
		}
	}	


	
	public static void purchaseTicketViaCreditPoints(String movie, int quantity, String day, UserCCDetails userC,
			UserDetails userD, TheatreSchedule temp) {
		// TODO Auto-generated method stub


		int movieId = 0;
		int order_id = 0;

		String query = "select movie_id from Movie where title= '" + movie + "'";
		rs = DBConnections.openDbConnectionForSelect(query);
		try {
			while(rs.next()){
				movieId = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnections.closeDbConnection();
		}
		query = "insert into OrderDetails values (seq_order.nextval, " + quantity + ", '" + userC.getCardNumber() + "', " + 
				temp.getScheduleId() + ", " + movieId + ", sysdate)";
		int result = DBConnections.openDbConnectionForUpdate(query);
		if(result==1)
		{
			query = "select order_id from OrderDetails where card_no = " + userC.getCardNumber() + " and schedule_id = " + 
					temp.getScheduleId() + "and rownum=1 order by order_id DESC";
			rs = DBConnections.openDbConnectionForSelect(query);
			try {
				while (rs.next()){
					order_id = rs.getInt(1);
					break;
				}// while
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DBConnections.closeDbConnection();
			}
			query = "insert into Purchase values (" + userD.getMemberId() + ", " + order_id + ")";
			result = DBConnections.openDbConnectionForUpdate(query);
			DBConnections.closeDbConnection();

			query = "update Schedule set availability = availability - " + quantity + " where schedule_id = " + temp.getScheduleId();
			result = DBConnections.openDbConnectionForUpdate(query);
			DBConnections.closeDbConnection();
			int deductCredit = temp.getPrice() * quantity;
			query = "update membership set credit_points = credit_points - " + deductCredit + " where member_id = " + userD.getMemberId();
			result = DBConnections.openDbConnectionForUpdate(query);
			DBConnections.closeDbConnection();
		}// else
	}

	public static void guestPurchase(String movie, int quantity, String day, TheatreSchedule temp, String phone, String cc, String email) {
		// TODO Auto-generated method stub
		int movieId=0;
		int order_id=0;
		String query = "select movie_id from Movie where title= '" + movie + "'";
		rs = DBConnections.openDbConnectionForSelect(query);
		try {
			while(rs.next()){
				movieId = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnections.closeDbConnection();
		}
		
		query = "insert into OrderDetails values (seq_order.nextval, " + quantity + ", '" + cc + "', " + 
				temp.getScheduleId() + ", " + movieId + ", sysdate)";
		int result = DBConnections.openDbConnectionForUpdate(query);
		if(result==1)
		{
			query = "select order_id from OrderDetails where card_no = " + cc + " and schedule_id = " + 
					temp.getScheduleId() + "and rownum=1 order by order_id DESC";
			rs = DBConnections.openDbConnectionForSelect(query);
			try {
				while (rs.next()){
					order_id = rs.getInt(1);
					break;
				}// while
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DBConnections.closeDbConnection();
			}
			
			query = "insert into guestorder values ("+ order_id +", '"+email+"', '"+ phone +"')";
			System.out.println(query);
			result = DBConnections.openDbConnectionForUpdate(query);
			DBConnections.closeDbConnection();
			
			query = "update Schedule set availability = availability - " + quantity + " where schedule_id = " + temp.getScheduleId();
			result = DBConnections.openDbConnectionForUpdate(query);
			DBConnections.closeDbConnection();	
		}
	}
}
