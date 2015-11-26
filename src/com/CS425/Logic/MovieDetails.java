package com.CS425.Logic;

import java.util.Scanner;

import com.CS425.Db.DBMovieDetails;
import com.CS425.Db.DBQueries;
import com.CS425.bean.UserCCDetails;
import com.CS425.bean.UserDetails;

public class MovieDetails {
		
	/*public static void main(String args[])
	{
		MovieDetails.viewMovieDetail("Minions");
		
	}*/
	
	public static boolean viewMovieDetail(String movie, UserDetails userDetails, UserCCDetails ccDetails)
	{	
		Scanner sc=new Scanner(System.in);
		
		DBMovieDetails.getMovieDetails(movie);
		DBQueries.showMovieReviews(movie);
		
		boolean flag = true;
		
		while(flag)
		{
			System.out.println("\nSelect from below options for the "+movie+" movie");
			System.out.println("1. Buy Ticket");
			System.out.println("2. Previous Screen");
			if(userDetails != null)
			{
				System.out.println("3. Create Discussion Thread");
				System.out.println("4. Reply on Discussion");
				System.out.println("5. Like the comment");
				System.out.println("6. Logout");
			}
			
			
			int choice=Integer.parseInt(sc.nextLine());
			
			switch(choice)
			{
				case 1:
					buyTicket(movie);
					break;
				case 2:
					{
						flag = false;
						return true;
					}
						
				case 3:
					{
						CreateReviewThread review = new CreateReviewThread();
						review.createThread(userDetails, movie);
						System.out.println("Review thread created\n");
						break;
					}
				
				case 4 :
				{
					ReplyMovieReview replyReview = new ReplyMovieReview();
					replyReview.replyMovieReview(userDetails, movie);
					break;
				}
				
				case 5 :
				{
					break;
				}
				
				case 6 :
				{
					flag = false;
					return false;
				}
				
			}
			
		}
		
		return true;
		
	}
	
	public static void buyTicket(String movie)
	{
		MovieDetailSchedule mds= new MovieDetailSchedule();
		mds.viewMovieSchedule(movie);
		
		
	}
	
	
}
