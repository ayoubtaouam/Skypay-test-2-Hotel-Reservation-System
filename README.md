# Hotel Reservation System – Technical Test 2

This project implements a simple hotel reservation system in Java, as specified in the Technical Test 2.

## ✅ Features

- **User Management**: Create or update users with a unique ID and balance.
- **Room Management**: Create or update rooms by ID, type, and price per night. Room updates do not affect past bookings.
- **Booking System**:
  - Book rooms for specific date ranges.
  - Prevent overlapping bookings.
  - Check user balance before booking.
  - Automatically deduct balance upon booking.
- **Information Display**:
  - `printAll()` shows rooms and bookings from latest to oldest.
  - `printAllUsers()` lists users from latest to oldest.
- **Error Handling**:
  - Validates dates, availability, and balance.
  - Graceful error messages for invalid operations.
 
## 🖊 Notes
- **Date Formatting**: I used the `ParseDate.parseDate("dd/MM/yyyy")` method in order to allow bookings to use readable string date formats (e.g., `"30/06/2026"`), which results in consider only the date part (year, month, day) for booking comparison (I tried to stick to the provided service, it would have been easier using `LocalDate` :) ).
- **Date Formatting in printing information**: Format the date to show only the day, month and the year.
- **Testing**: In the main class I surrounded the methods that might raise exceptions in order to get the appropriate feedback for each method.
- **Potential naming issue**: In the test rooms the last one the room type is "suite", in the implementation I considered it `MASTER` as defined in the room entity definition.

## 📸 Result Screenshot
![Screenshot (73)](https://github.com/user-attachments/assets/aa18d372-c0d2-4d0c-b70b-c0c664fee3b3)

## Bonus questions
- **1**: No, it's a violation to the single responsability principle, it would be better to separate concerns and split the service into small services, each one manage one component/entity (`RoomService`, `UserService`...), making the code maintainable and scalable.
- **2**: Here I stored room's data i the moment of the booking in the `Booking` class. Another way is to keep track of the changes apllied to the rooms with loosing older data, in other words each modification will update the room's state without loosing the previous one like storing versions of the rooms.
