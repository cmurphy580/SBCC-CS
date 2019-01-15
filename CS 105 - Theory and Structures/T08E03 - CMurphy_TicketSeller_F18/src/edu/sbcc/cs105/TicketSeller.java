package edu.sbcc.cs105;

public class TicketSeller {
	private int initialTicketAllotment;
	private int numberOfBuyers = 0; 
	static public int TOO_MANY_TICKETS_REQUESTED = -1; //set to -1 for proper return type. ticketAllotment should always be positive. return variable if not.
	static private int MAXIMUM_TICKETS_ALLOWED = 5;
	
	public TicketSeller(int initialTicketAllotment) {
		this.initialTicketAllotment = initialTicketAllotment;
	}
	
	public int requestTickets(int ticketRequest) {
		System.out.printf("Input requested tickets: %d\n", ticketRequest);
		if ((ticketRequest >= MAXIMUM_TICKETS_ALLOWED) || (initialTicketAllotment - ticketRequest < 0)) {
			System.out.println("Too many tickets requested, please try again.");
			return TOO_MANY_TICKETS_REQUESTED;
		} else if (initialTicketAllotment - ticketRequest > 0) {
			numberOfBuyers++;
			initialTicketAllotment -= ticketRequest; 
			System.out.printf("Thank you for your purchase. There are %d tickets remaining\n", initialTicketAllotment);
		} else if (initialTicketAllotment - ticketRequest == 0) {
			numberOfBuyers++;
			initialTicketAllotment -= ticketRequest; 
			System.out.println("Thank you for your purchase. There are no tickets remaining.");
			System.out.printf("You have had %d buyers.\n", numberOfBuyers);
		}
		return initialTicketAllotment; 
	}
	
	public int getNumberOfBuyers() {
		return numberOfBuyers;
	}
}
