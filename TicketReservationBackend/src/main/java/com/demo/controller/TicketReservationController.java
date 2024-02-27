package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.demo.entity.TicketReservation;
import com.demo.repository.TicketReservationRepo;
import com.demo.servicesImpl.TicketReservationImpl;

import jakarta.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/api/ticket-reservations")
public class TicketReservationController {
	
	@Autowired
	private TicketReservationRepo reservationRepo; 
	
    @Autowired
    private TicketReservationImpl ticketReservationService;
    
    @GetMapping("/")
    public List<TicketReservation> ticket() {
		return reservationRepo.findAll();
	}

    @PostMapping("/")
    public ResponseEntity<TicketReservation> saveTicketBooking(@Valid @RequestBody TicketReservation ticketBooking) {
        TicketReservation savedTicketBooking = ticketReservationService.saveTicketBooking(ticketBooking);
        return new ResponseEntity<>(savedTicketBooking, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketReservation> getTicketBookingById(@Valid @PathVariable Long id) {
        TicketReservation ticketBooking = ticketReservationService.getTicketBookingById(id);
        return new ResponseEntity<>(ticketBooking, HttpStatus.OK);
    }

//    @GetMapping
//    public ResponseEntity<List<TicketReservation>> getAllTicketBookings() {
//        List<TicketReservation> ticketBookings = ticketReservationService.getAllTicketBookings();
//        return new ResponseEntity<>(ticketBookings, HttpStatus.OK);
//    }

    @PutMapping("/update")
    public ResponseEntity<TicketReservation> updateTicketBooking(@Valid @RequestBody TicketReservation ticketBooking, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        TicketReservation updatedTicketBooking = ticketReservationService.updateTicketBooking(ticketBooking);
        return ResponseEntity.ok(updatedTicketBooking);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicketBooking(@Valid @PathVariable Long id) {
        ticketReservationService.deleteTicketBooking(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
