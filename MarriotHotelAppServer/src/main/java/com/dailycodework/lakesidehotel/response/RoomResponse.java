package com.dailycodework.lakesidehotel.response;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.tomcat.util.codec.binary.Base64;

import java.math.BigDecimal;
import java.util.List;

@Data

public class RoomResponse {
    private Long id;
    @Setter
	private String roomType;
    private BigDecimal roomPrice;
    private boolean isBooked;
    private String photo;
    private List<BookingResponse>bookings;

    public RoomResponse(Long id, String roomType, BigDecimal roomPrice) {
        this.id = id;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
    }

    public RoomResponse(Long id, String roomType, BigDecimal roomPrice, boolean isBooked,
                        byte[] photoBytes , List<BookingResponse> bookings) {
        this.id = id;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
        this.isBooked = isBooked;
        this.photo = photoBytes != null ? Base64.encodeBase64String(photoBytes) : null;
       this.bookings = bookings;
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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public List<BookingResponse> getBookings() {
		return bookings;
	}

	public void setBookings(List<BookingResponse> bookings) {
		this.bookings = bookings;
	}

	public RoomResponse() {
		super();
	}
    

}
