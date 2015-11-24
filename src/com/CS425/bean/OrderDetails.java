package com.CS425.bean;

public class OrderDetails {
	
	private int orderId;
	private String movieName;
	private String theatreName;
	private String theatreLocation;
	private String time;
	private String Day;
	private String cardNumber;
	private int price;
	private int quantity;
	private int screenNumber;
	
	public OrderDetails(int orderId, String movieName, String theatreName,
			String theatreLocation, String time, String day, String cardNumber,
			int price, int quantity, int screenNumber) {
		super();
		this.orderId = orderId;
		this.movieName = movieName;
		this.theatreName = theatreName;
		this.theatreLocation = theatreLocation;
		this.time = time;
		Day = day;
		this.cardNumber = cardNumber;
		this.price = price;
		this.quantity = quantity;
		this.screenNumber = screenNumber;
	}

	public int getOrderId() {
		return orderId;
	}

	public String getMovieName() {
		return movieName;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public String getTheatreLocation() {
		return theatreLocation;
	}

	public String getTime() {
		return time;
	}

	public String getDay() {
		return Day;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getScreenNumber() {
		return screenNumber;
	}
}
