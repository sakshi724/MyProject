package com.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "Reservation")
public class TicketReservation {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    @NotBlank(message = "USername must be required")
    private String userName;
    
    @Column
    @NotBlank(message = "mobile number required")
    private String mobNumb;
    
    @Column
    @NotBlank(message = "User email is required")  // Ensure you have an attribute for user email
    private String email;
    @Column
    @NotBlank(message = "bus name is required")
    private String busName;
    
    @Column
    @NotBlank(message = "destination require")
    private String destination;
    
    @Column
    @NotBlank(message = "From location is required")
    private String fromDest;

    @Column
    @NotBlank(message = "To location is required")
    private String toDest;
    
    @Column
    @NotBlank(message = "To location is required")
    private String Date;

//    @Column
//    @Min(value = 1, message = "Seats should be at least 1")
//    private int seats;
    
    @OneToOne(cascade = CascadeType.PERSIST)
    private Payments payment;
    
    

	public TicketReservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TicketReservation(Long id, @NotBlank(message = "USername must be required") String userName,
			@NotBlank(message = "mobile number required") String mobNumb,
			@NotBlank(message = "User email is required") String email,
			@NotBlank(message = "bus name is required") String busName,
			@NotBlank(message = "destination require") String destination,
			@NotBlank(message = "From location is required") String fromDest,
			@NotBlank(message = "To location is required") String toDest,
			@NotBlank(message = "To location is required") String date, Payments payment) {
		super();
		this.id = id;
		this.userName = userName;
		this.mobNumb = mobNumb;
		this.email = email;
		this.busName = busName;
		this.destination = destination;
		this.fromDest = fromDest;
		this.toDest = toDest;
		Date = date;
		this.payment = payment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobNumb() {
		return mobNumb;
	}

	public void setMobNumb(String mobNumb) {
		this.mobNumb = mobNumb;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public Payments getPayment() {
		return payment;
	}

	public void setPayment(Payments payment) {
		this.payment = payment;
	}
    
    
    
    
    
}
