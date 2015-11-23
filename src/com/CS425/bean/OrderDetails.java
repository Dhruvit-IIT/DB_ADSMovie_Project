package com.CS425.bean;

public class OrderDetails {
	
	private int orderId;
	private String movieName;
	private String theatreName;
	private String theatreLocation;
	private String time;
	private int price;
	private int quantity;
	private int screenNumber;
	
	public OrderDetails(int orderId, String movieName, String theatreName, String theatreLocation,
			String time, int price, int quantity, int screenNumber) {
		super();
		this.orderId = orderId;
		this.movieName = movieName;
		this.theatreName = theatreName;
		this.theatreLocation = theatreLocation;
		this.time = time;
		this.price = price;
		this.quantity = quantity;
		this.screenNumber = screenNumber;
	}

	public String getTheatreLocation() {
		return theatreLocation;
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

	public String getTime() {
		return time;
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
