package edu.sbcc.cs105;

public class Main {

	public static void main(String[] args) {
		TicketSeller seller = new TicketSeller(8);
		seller.requestTickets(1);
		seller.requestTickets(2);
		seller.requestTickets(5);
		seller.requestTickets(9);
		seller.requestTickets(3);
		seller.requestTickets(2);
	}
}
