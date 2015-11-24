package com.CS425.Logic;

import com.CS425.bean.*;

public class test_driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserHome user = new UserHome();
		UserDetails details = new UserDetails("Dhruvit", "chicago", "1234567890","11-01-2015",
				"d@s.com", "Male", 10,
				10, "abc", "xyz");
		UserCCDetails cc = new UserCCDetails("Visa", "1234567812345678" , "10/20", "Dhruvit");
		details.setMemberId(1038);
		user.userHomeMenu(details, cc);
	}

}
