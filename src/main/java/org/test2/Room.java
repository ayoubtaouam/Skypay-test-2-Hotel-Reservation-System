package org.test2;

public class Room {
    private final int id;
    private RoomType roomType;
    private int pricePerNight;

    public Room(int id, RoomType roomType, int pricePerNight) {
        this.id = id;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
    }

    public int getId() {
        return id;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public int getPricePerNight() {
        return pricePerNight;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public void setPricePerNight(int pricePerNight) {
        this.pricePerNight = pricePerNight;
    }
}
