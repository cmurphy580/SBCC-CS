package edu.sbcc.cs105;

public class Item {
	private double price;
	private boolean isPet;
	private int quantity;
	public Item(double price, boolean isPet, int quantity) {
		this.price = price;
		this.isPet = isPet;
		this.quantity = quantity;
	}
	
	
	public double getPrice() {
		return price;
	}
	public boolean getIsPet() {
		return isPet;
	}
	public int getQuantity() {
		return quantity;
	}
}
