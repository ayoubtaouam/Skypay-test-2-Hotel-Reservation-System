package org.test2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Service {
    private final ArrayList<Room> rooms = new ArrayList<>();
    private final ArrayList<User> users = new ArrayList<>();
    private final ArrayList<Booking> bookings = new ArrayList<>();

    void setRoom(int roomNumber, RoomType roomType, int roomPricePerNight) {
        for (Room room: rooms) {
            if (room.getId() == roomNumber) {
                room.setRoomType(roomType);
                room.setPricePerNight(roomPricePerNight);
                return;
            }
        }
        Room room = new Room(roomNumber, roomType, roomPricePerNight);
        rooms.add(room);
    }
    void bookRoom(int userId, int roomNumber, Date checkIn, Date checkOut) {
        if (checkOut.before(checkIn)) {
            throw new RuntimeException("The checkout date cannot be before the check in date!");
        }
        long nights = (checkOut.getTime() - checkIn.getTime()) / (1000*60*60*24);
        if (nights == 0) {
            throw new RuntimeException("You have to book at least one night!");
        }
        User user = users.stream().filter(u -> u.getId() == userId).findAny().orElseThrow(() -> new RuntimeException("User not found!"));
        Room room = rooms.stream().filter(r -> r.getId() == roomNumber).findAny().orElseThrow(() -> new RuntimeException("Room not found!"));
        if (user.getBalance() < room.getPricePerNight() * nights) {
            throw new RuntimeException("Insufficient balance");
        }
        for (Booking booking: bookings) {
            if (booking.getRoomNumber() == roomNumber){
                if (!(checkOut.before(booking.getCheckIn()) || checkIn.after(booking.getCheckOut()))) {
                    throw new RuntimeException("The room is not available in that period!");
                }
            }
        }
        Booking booking = new Booking(user, room, checkIn, checkOut);
        user.setBalance(user.getBalance() - (int) (room.getPricePerNight() * nights));
        bookings.add(booking);
    }
    void printAll() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Booking booking;
        User user;
        Room room;
        System.out.println("Rooms information:");
        for (int i = rooms.size() - 1; i >= 0; i--) {
            room = rooms.get(i);
            System.out.println("Room number: " + room.getId() +
                    ", Room type: " + room.getRoomType() +
                    ", Price per night: " + room.getPricePerNight());
        }

        System.out.println("Bookings information:");
        for (int i = bookings.size() - 1; i >= 0; i--) {
            booking = bookings.get(i);
            user = booking.getUser();
            System.out.println("User ID: " + user.getId() + ", Room number: "
                    + booking.getRoomNumber() + ", Room type: " + booking.getRoomType()
                    + ", Price per night: " + booking.getPricePerNight()
                    + ", Check in date: " + dateFormat.format(booking.getCheckIn())
                    + ", Check out date: " + dateFormat.format(booking.getCheckOut()));
        }
    }
    void setUser(int userId, int balance) {
        for (User user : users) {
            if(user.getId() == userId) {
                user.setBalance(balance);
                return;
            }
        }
        User user = new User(userId, balance);
        users.add(user);
    }
    void printAllUsers() {
        User user;
        System.out.println("Users info:");
        for (int i = users.size() - 1; i >= 0; i--) {
            user = users.get(i);
            System.out.println("User ID: " + user.getId() + ", User Balance: " + user.getBalance());
        }
    }

}
