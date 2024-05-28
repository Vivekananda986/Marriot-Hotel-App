package com.dailycodework.lakesidehotel.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Getter
@Setter

public class BookedRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long bookingId;

    @Column(name = "check_in")
    private LocalDate checkInDate;

    @Column(name = "check_out")
    private LocalDate checkOutDate;

    @Column(name = "guest_fullName")
    private String guestFullName; 

    @Column(name = "guest_email")
    private String guestEmail;

    @Column(name = "adults")
    private int NumOfAdults;

    @Column(name = "children")
    private int NumOfChildren;

    @Column(name = "total_guest")
    private int totalNumOfGuest;

    @Column(name = "confirmation_Code")
    private String bookingConfirmationCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    public void calculateTotalNumberOfGuest(){
        this.totalNumOfGuest = this.NumOfAdults + NumOfChildren;
    }

    public void setNumOfAdults(int numOfAdults) {
        NumOfAdults = numOfAdults;
        calculateTotalNumberOfGuest();
    }

    public void setNumOfChildren(int numOfChildren) {
        NumOfChildren = numOfChildren;
        calculateTotalNumberOfGuest();
    }

    public void setBookingConfirmationCode(String bookingConfirmationCode) {
        this.bookingConfirmationCode = bookingConfirmationCode;
    }

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public LocalDate getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}

	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public String getGuestFullName() {
		return guestFullName;
	}

	public void setGuestFullName(String guestFullName) {
		this.guestFullName = guestFullName;
	}

	public String getGuestEmail() {
		return guestEmail;
	}

	public void setGuestEmail(String guestEmail) {
		this.guestEmail = guestEmail;
	}

	public int getTotalNumOfGuest() {
		return totalNumOfGuest;
	}

	public void setTotalNumOfGuest(int totalNumOfGuest) {
		this.totalNumOfGuest = totalNumOfGuest;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public int getNumOfAdults() {
		return NumOfAdults;
	}

	public int getNumOfChildren() {
		return NumOfChildren;
	}

	public String getBookingConfirmationCode() {
		return bookingConfirmationCode;
	}

	public BookedRoom(Long bookingId, LocalDate checkInDate, LocalDate checkOutDate, String guestFullName,
			String guestEmail, int numOfAdults, int numOfChildren, int totalNumOfGuest, String bookingConfirmationCode,
			Room room) {
		super();
		this.bookingId = bookingId;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.guestFullName = guestFullName;
		this.guestEmail = guestEmail;
		NumOfAdults = numOfAdults;
		NumOfChildren = numOfChildren;
		this.totalNumOfGuest = totalNumOfGuest;
		this.bookingConfirmationCode = bookingConfirmationCode;
		this.room = room;
	}

	public BookedRoom() {
		super();
	}
    
}
