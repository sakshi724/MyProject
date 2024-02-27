package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.TicketGeneration;

public interface TicketGenerationRepository extends JpaRepository<TicketGeneration, Long>{
	TicketGeneration findByDestination(String destination);
}
