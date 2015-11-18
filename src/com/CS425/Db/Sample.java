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
		
		DBConnections.query = "select title from movie";
		rs = DBConnections.openDbConnectionForSelect(DBConnections.query);
		try {
			while(rs.next())
				System.out.println(rs.getString(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBConnections.closeDbConnection();
		}
	}
}
