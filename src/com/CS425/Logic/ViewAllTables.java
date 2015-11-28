package com.CS425.Logic;

import java.util.Scanner;

import com.CS425.Db.DBQueries;

public class ViewAllTables {
	
	public void ViewAllTables()
	{
		DBQueries.viewListOfTables();
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the table name to see the data : ");
		String table_name = input.nextLine();
		if(DBQueries.validateTableName(table_name.toUpperCase()))
		DBQueries.viewTableDetails(table_name);
		else
			System.out.println("The table you have entered does not exist. Please enter correct table name.");
	};
	
}
