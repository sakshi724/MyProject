package com.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "ticketgenerate")
public class TicketGeneration {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank(message = "BusName is required")
    private String busName;

    @NotBlank(message = "BusName is required")
    private String destination;
    
    @NotBlank(message = "From-Destination is required")
    private String fromDest;
    
    @NotBlank(message = "From-Destination is required")
    private String toDest;

    @NotBlank(message = "Date is required")
    private String date;
    
    @NotNull(message = "Price Empty")
    private String price;
    
    @NotNull(message = "Price Empty")
    private String seats;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getFromDest() {
		return fromDest;
	}

	public void setFromDest(String fromDest) {
		this.fromDest = fromDest;
	}

	public String getToDest() {
		return toDest;
	}

	public void setToDest(String toDest) {
		this.toDest = toDest;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSeats() {
		return seats;
	}

	public void setSeats(String seats) {
		this.seats = seats;
	}

	public TicketGeneration(Long id, @NotBlank(message = "BusName is required") String busName,
			@NotBlank(message = "BusName is required") String destination,
			@NotBlank(message = "From-Destination is required") String fromDest,
			@NotBlank(message = "From-Destination is required") String toDest,
			@NotBlank(message = "Date is required") String date, @NotNull(message = "Price Empty") String price,
			@NotNull(message = "Price Empty") String seats) {
		super();
		this.id = id;
		this.busName = busName;
		this.destination = destination;
		this.fromDest = fromDest;
		this.toDest = toDest;
		this.date = date;
		this.price = price;
		this.seats = seats;
	}

	public TicketGeneration() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
