package org.test2;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Service service = new Service();

        // Create rooms
        service.setRoom(1, RoomType.STANDARD, 1000);
        service.setRoom(2, RoomType.JUNIOR, 2000);
        service.setRoom(3, RoomType.MASTER, 3000);

        // Create users
        service.setUser(1, 5000);
        service.setUser(2, 10000);

        // Booking 1: User 1 books Room 2 from 30/06/2026 to 07/07/2026
        try {
            service.bookRoom(1, 2, ParseDate.parseDate("30/06/2026"), ParseDate.parseDate("07/07/2026"));
        } catch (RuntimeException e) {
            System.out.println("Booking 1 failed: " + e.getMessage());
        }

        // Booking 2: User 1 books Room 2 from 07/07/2026 to 30/06/2026
        try {
            service.bookRoom(1, 2, ParseDate.parseDate("07/07/2026"), ParseDate.parseDate("30/06/2026"));
        } catch (RuntimeException e) {
            System.out.println("Booking 2 failed: " + e.getMessage());
        }

        // Booking 3: User 1 books Room 1 from 07/07/2026 to 08/07/2026
        try {
            service.bookRoom(1, 1, ParseDate.parseDate("07/07/2026"), ParseDate.parseDate("08/07/2026"));
        } catch (RuntimeException e) {
            System.out.println("Booking 3 failed: " + e.getMessage());
        }

        // Booking 4: User 2 books Room 1 from 07/07/2026 to 09/07/2026
        try {
            service.bookRoom(2, 1, ParseDate.parseDate("07/07/2026"), ParseDate.parseDate("09/07/2026"));
        } catch (RuntimeException e) {
            System.out.println("Booking 4 failed: " + e.getMessage());
        }

        // Booking 5: User 2 books Room 3 from 07/07/2026 to 08/07/2026
        try {
            service.bookRoom(2, 3, ParseDate.parseDate("07/07/2026"), ParseDate.parseDate("08/07/2026"));
        } catch (RuntimeException e) {
            System.out.println("Booking 5 failed: " + e.getMessage());
        }

        // Change Room 1 to MASTER with new price
        service.setRoom(1, RoomType.MASTER, 10000);

        // Final Output
        System.out.println("\n=== All Bookings ===");
        service.printAll();

        System.out.println("\n=== All Users ===");
        service.printAllUsers();
    }
}