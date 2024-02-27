package com.demo.exceptions;

public class TicketUpdateException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TicketUpdateException(Long id) {
        super("Unable to update ticket with id: " + id + ". Ticket not found or invalid update.");
    }
}
