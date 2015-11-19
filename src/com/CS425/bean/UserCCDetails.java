package com.CS425.bean;

public class UserCCDetails {
	
	private int memberId;
	private String cardType;
	private String cardNumber;
	private String expiry;
	private String nameOnCard;
	
	public UserCCDetails(String cardType, String cardNumber, String expiry,
			String nameOnCard) {
		super();
		this.cardType = cardType;
		this.cardNumber = cardNumber;
		this.expiry = expiry;
		this.nameOnCard = nameOnCard;
	}
	
	

}
