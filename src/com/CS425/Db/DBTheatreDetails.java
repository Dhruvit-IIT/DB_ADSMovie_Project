package com.CS425.Db;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBTheatreDetails {
	
	static ResultSet rs;
	static int result;


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

}
