package org.test2;


import java.util.Date;

public class Booking {
    private User user;
    private int roomNumber;
    private RoomType roomType;
    private int pricePerNight;
    private Date checkIn;
    private Date checkOut;

    public Booking(User user, Room room, Date checkIn, Date checkOut) {
        this.user = user;
        this.roomNumber = room.getId();
        this.roomType = room.getRoomType();
        this.pricePerNight = room.getPricePerNight();
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public User getUser() {
        return user;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public int getPricePerNight() {
        return pricePerNight;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }
}
