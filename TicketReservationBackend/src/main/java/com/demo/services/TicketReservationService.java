package com.demo.services;

import com.demo.entity.TicketReservation;

public interface TicketReservationService {
	
	TicketReservation saveTicketBooking(TicketReservation ticketBooking);
	TicketReservation getTicketBookingById(Long id);
	TicketReservation updateTicketBooking(TicketReservation ticketBooking);
    void deleteTicketBooking(Long id);
}
