package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.TicketReservation;

@Repository
public interface TicketReservationRepo extends JpaRepository<TicketReservation, Long>{

}
