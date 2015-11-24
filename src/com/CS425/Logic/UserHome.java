package com.CS425.Logic;

import java.util.Scanner;

import com.CS425.Db.DBQueries;
import com.CS425.bean.*;

public class UserHome
{
	int option;
	//need to get credit card details as well
	public void userHomeMenu(UserDetails userDetails, UserCCDetails ccDetails)
	{
		System.out.printf("**************Welcome %s **************%n", userDetails.getUserName());
		System.out.println("----------------------------------------------");
		boolean flag = true;
		Scanner input = new Scanner(System.in);
		
		/*Recommendations*/
		DBQueries.movieRecommendations(userDetails.getMemberId());
		
		System.out.println("----------------------------------------------");
		
		while(flag)
		{
			System.out.println("\nPlease enter option number from below menu : \n");
			System.out.println("----------------------------------------------");
			System.out.println("1 - View/Edit Profile");
			System.out.println("2 - View Orders");
			System.out.println("3 - Search Movie");
			System.out.println("4 - Search Theatre");
			System.out.println("5 - Logout");
			option = Integer.parseInt(input.nextLine());
			
			switch(option)
			{
			case 1:
				{
					ViewEditProfile vep = new ViewEditProfile();
					boolean ret = vep.viewEditProfile(userDetails);
					flag = ret;
						
					break;
				}
			case 2:
				{
					break;
				}
			case 3:
				{
					break;
				}
			case 4:
				{
					break;
				}
			case 5:
				{
					flag = false;
					break;
				}
			default :
				{
					System.out.println("Please select from one of the provided option\n");
					break;
				}
			}
			

		}
	}
	
}
