package com.demo.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.TicketReservation;
import com.demo.exceptions.TicketNotFoundException;
import com.demo.exceptions.TicketUpdateException;
import com.demo.repository.TicketReservationRepo;
import com.demo.services.TicketReservationService;

@Service
public class TicketReservationImpl implements TicketReservationService {

	@Autowired
    private TicketReservationRepo ticketReservationRepository;

    @Override
    public TicketReservation saveTicketBooking(TicketReservation ticketBooking) {
        return ticketReservationRepository.save(ticketBooking);
    }

    @Override
    public TicketReservation getTicketBookingById(Long id) {
        return ticketReservationRepository.findById(id)
                .orElseThrow(() -> new TicketNotFoundException(id));
    }

    @Override
    public TicketReservation updateTicketBooking(TicketReservation ticketBooking) {
        Long id = ticketBooking.getId();
        if (id != null && ticketReservationRepository.existsById(id)) {
            return ticketReservationRepository.save(ticketBooking);
        } else {
            throw new TicketUpdateException(id);
        }
    }

    @Override
    public void deleteTicketBooking(Long id) {
        ticketReservationRepository.deleteById(id);
    }
}
