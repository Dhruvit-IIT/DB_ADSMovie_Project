package com.CS425.Logic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.CS425.Db.FetchData;
import com.CS425.bean.OrderDetails;

public class UserOrderHistory {

	public boolean viewOrderHistory(int memberId){

		FetchData data = new FetchData();
		int option;
		Scanner sc = new Scanner(System.in);
		ArrayList<OrderDetails> orderHistory = new ArrayList<OrderDetails>();
		orderHistory = data.getUserOrderHistory(memberId);

		System.out.println("\n-----------Order History---------");
		if(orderHistory == null)
			System.out.println("*No order history found.*");
		else{
			System.out.println("Order ID\tMovie Name\tTheatre Name\tTheatre Location\tDay\tTime\tQuantity");
			Iterator<OrderDetails> orderItr = orderHistory.iterator();
			while(orderItr.hasNext()){
				System.out.print(orderItr.next().getOrderId() + "\t");
				System.out.print(orderItr.next().getMovieName() + "\t");
				System.out.print(orderItr.next().getTheatreName() + "\t");
				System.out.print(orderItr.next().getTheatreLocation() + "\t");
				System.out.print(orderItr.next().getDay() + "\t");
				System.out.print(orderItr.next().getTime() + "\t");
				System.out.print(orderItr.next().getQuantity() + "\t");
			}// While
		}

		System.out.println("\n1. Home");
		System.out.println("2. Logout");
		option = Integer.parseInt(sc.nextLine());

		while(true){
			switch(option){
			case 1:
				sc.close();
				return true;
			case 2:
				sc.close();
				return false;
			default:
				System.out.println("Select appropriate option.");
			}// Switch
		}// While
	}// Function
}