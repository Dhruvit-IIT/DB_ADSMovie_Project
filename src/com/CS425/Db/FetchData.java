package com.CS425.Db;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.CS425.bean.UserCCDetails;
import com.CS425.bean.UserDetails;

public class FetchData {
	
	ResultSet rs;
	String query;

	public boolean validateUserLogin(String email, String pass) {
		
		query = "select count(*) from MemberLogin where email = '" + email + "' and password = '" + pass + "'";
		boolean isValidUser = false;
		rs = DBConnections.openDbConnectionForSelect(query);
		try {
			while(rs.next())
				if(rs.getInt(1) != 0)
				isValidUser = true;
			//rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBConnections.closeDbConnection();
		}
		return isValidUser;
	}

	public UserDetails getUserDetails(String email) {
		
		UserDetails userD = null;
		query = "select * from USERREGISTRATION u inner join MEMBERSHIP m on u.member_id = m.member_id where u.email = '" + email + "'";
		rs = DBConnections.openDbConnectionForSelect(query);
		try {
			while(rs.next()){
				userD = new UserDetails(rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), 
						                rs.getString(7), rs.getInt(9), rs.getInt(10), rs.getString(10), rs.getString(11));
				userD.setMemberId(rs.getInt(1));
			//rs.close();	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBConnections.closeDbConnection();
		}
		return userD;
	}

	public UserCCDetails getUserCCDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean validateMovie(String movie) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean validateTheatre(String theatre) {
		// TODO Auto-generated method stub
		return false;
	}
}
