package com.dailycodework.lakesidehotel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter

public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String roomType;
    private BigDecimal roomPrice;
    private boolean isBooked = false;
    @Lob
    private Blob photo;

    @OneToMany(mappedBy="room", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BookedRoom> bookings;

    public Room() {
        this.bookings = new ArrayList<>();
    }
    public void addBooking(BookedRoom booking){
        if (bookings == null){
            bookings = new ArrayList<>();
        }
        bookings.add(booking);
        booking.setRoom(this);
        isBooked = true;
        String bookingCode = RandomStringUtils.randomNumeric(10);
        booking.setBookingConfirmationCode(bookingCode);
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public BigDecimal getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(BigDecimal roomPrice) {
		this.roomPrice = roomPrice;
	}
	public boolean isBooked() {
		return isBooked;
	}
	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}
	public Blob getPhoto() {
		return photo;
	}
	public void setPhoto(Blob photo) {
		this.photo = photo;
	}
	public List<BookedRoom> getBookings() {
		return bookings;
	}
	public void setBookings(List<BookedRoom> bookings) {
		this.bookings = bookings;
	}
    
}
