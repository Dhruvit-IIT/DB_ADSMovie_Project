package com.CS425.Db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.CS425.bean.StaffDetails;

public class DBStaffProcessing {

	static ResultSet rs;
	
	public ArrayList<String> fetchTheatreList() {
		ArrayList<String> allTheaterList = new ArrayList<String>();
		
		DBConnections.query = "select theatre_id, name from THEATRE";
		rs = DBConnections.openDbConnectionForSelect(DBConnections.query);
		
		try {
			while(rs.next())
				allTheaterList.add(rs.getInt(1) + ": " + rs.getString(2));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBConnections.closeDbConnection();
		return allTheaterList;
	}

	public boolean insertStaffToDb(StaffDetails staffD) {
		
		int success1, success2;
		DBConnections.query = "insert into STAFFDETAILS values (seq_staff.nextval, '" + staffD.getName() + "', '" + staffD.getPhone() + "', '" +
		                       staffD.getSsn() + "', to_date('" + staffD.getDateOfJoining() + "','MM-DD-YYYY'), " + staffD.getDescId() + ", '" + 
				               staffD.getAddress() + "', '" + staffD.getEmail() + "', " + staffD.getTheatreId() + ")";
		success1 = DBConnections.openDbConnectionForUpdate(DBConnections.query);
		DBConnections.closeDbConnection();
		
		DBConnections.query = "insert into memberlogin values ('" + staffD.getEmail() + "', '" + staffD.getEmail().substring(1, 4) + "')";
		success2 = DBConnections.openDbConnectionForUpdate(DBConnections.query);
		DBConnections.closeDbConnection();
		
		if(success1 == 0 && success2 == 0)
			return false;
		return true;
	}
}