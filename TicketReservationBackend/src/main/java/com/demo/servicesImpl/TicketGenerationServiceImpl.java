package com.demo.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.TicketGeneration;
import com.demo.exceptions.TicketNotFoundException;
import com.demo.exceptions.TicketUpdateException;
import com.demo.repository.TicketGenerationRepository;
import com.demo.services.TicketGenerationService;


@Service
public class TicketGenerationServiceImpl implements TicketGenerationService{
	@Autowired
	private  TicketGenerationRepository ticketRepository;

   
    @Override
    public TicketGeneration saveTicket(TicketGeneration ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public TicketGeneration getTicketById(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new TicketNotFoundException(id));
    }

    @Override
    public TicketGeneration updateTicket(TicketGeneration ticket) {
        Long id = ticket.getId();
        if (id != null && ticketRepository.existsById(id)) {
            return ticketRepository.save(ticket);
        } else {
            throw new TicketUpdateException(id);
        }
    }

    @Override
    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }

    @Override
    public List<TicketGeneration> getAllTickets() {
        return ticketRepository.findAll();
    }
	
    @Override
    public TicketGeneration updateTicket(Long id, TicketGeneration ticket) {
        if (id != null && ticketRepository.existsById(id)) {
            ticket.setId(id); // Set the ID from the path variable
            return ticketRepository.save(ticket);
        } else {
            throw new TicketUpdateException(id);
        }
    }

	@Override
	public TicketGeneration getTicketByDestination(String destination) {
		
		return ticketRepository.findByDestination(destination);
	}
}