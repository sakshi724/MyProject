package com.demo.services;

import java.util.List;

import com.demo.entity.TicketGeneration;

public interface TicketGenerationService {
	TicketGeneration saveTicket(TicketGeneration ticket);
    TicketGeneration getTicketById(Long id);
    TicketGeneration updateTicket(TicketGeneration ticket);
    void deleteTicket(Long id);
    List<TicketGeneration> getAllTickets();
    TicketGeneration updateTicket(Long id, TicketGeneration ticket);
    TicketGeneration getTicketByDestination(String destination);
}
