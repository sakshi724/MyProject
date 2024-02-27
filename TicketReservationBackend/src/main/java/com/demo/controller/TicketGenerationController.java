package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.TicketGeneration;
import com.demo.repository.TicketGenerationRepository;
import com.demo.services.TicketGenerationService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/bus")
public class TicketGenerationController {
	
	@Autowired
	private TicketGenerationRepository generationRepository;
	
	@Autowired
    private TicketGenerationService ticketService;
	
	@GetMapping("/tDetails")
	public List<TicketGeneration> ticket() {
		return generationRepository.findAll();
	}

	@PostMapping("/save")
    public ResponseEntity<TicketGeneration> saveTicket(@Valid @RequestBody TicketGeneration ticket) {
        TicketGeneration savedTicket = ticketService.saveTicket(ticket);
        return ResponseEntity.ok(savedTicket);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketGeneration> getTicket(@PathVariable Long id) {
        TicketGeneration ticket = ticketService.getTicketById(id);
        return ResponseEntity.ok(ticket);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TicketGeneration>> getAllTickets() {
        List<TicketGeneration> allTickets = ticketService.getAllTickets();
        return ResponseEntity.ok(allTickets);
    }

    @PutMapping("/update")
    public ResponseEntity<TicketGeneration> updateTicket(@Valid @RequestBody TicketGeneration ticket) {
        TicketGeneration updatedTicket = ticketService.updateTicket(ticket);
        return ResponseEntity.ok(updatedTicket);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<TicketGeneration> updateTicket(@PathVariable Long id,@Valid @RequestBody TicketGeneration ticket
    ) {
        TicketGeneration updatedTicket = ticketService.updateTicket(id, ticket);
        return ResponseEntity.ok(updatedTicket);
    }
    
    @GetMapping("/destination/{destination}")
    public ResponseEntity<Object> getTicketByDestination(@PathVariable String destination) {
        TicketGeneration ticket = ticketService.getTicketByDestination(destination);

        if (ticket != null) {
            return ResponseEntity.ok().body("Ticket found: " + ticket.toString());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ticket not found for destination: " + destination);
        }
    }
   
}
