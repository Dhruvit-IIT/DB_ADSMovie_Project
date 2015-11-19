package com.CS425.Db;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FetchData {

	public boolean validateUserLogin(String email, String pass) {
		
		String query = "select count(*) from MemberLogin where email = '" + email + "' and password = '" + pass + "'";
		boolean isValidUser = false;
		ResultSet rs = DBConnections.openDbConnectionForSelect(query);
		try {
			while(rs.next())
				if(rs.getInt(1) != 0)
				isValidUser = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isValidUser;
	}

}
