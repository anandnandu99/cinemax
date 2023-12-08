// BookingController.java
package com.hexaware.cinemax.controllers;

import com.hexaware.cinemax.dto.BookingDTO;
import com.hexaware.cinemax.services.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingRestController {

    @Autowired
    private IBookingService bookingService;

    @PostMapping("/book-seat")
    public ResponseEntity<String> bookSeat(@RequestBody BookingDTO bookingDTO) {
        bookingService.bookSeat(bookingDTO);
        return ResponseEntity.ok("Seat booked successfully");
    }

    @GetMapping("/seat-numbers/{showId}")
    public ResponseEntity<List<String>> getSeatNumbersByShowId(@PathVariable int showId) {
        List<String> seatNumbers = bookingService.getSeatNumbersByShowId(showId);
        return ResponseEntity.ok(seatNumbers);
    }
    @GetMapping("/user-seat-numbers/{userId}")
    public ResponseEntity<List<String>> getSeatNumbersByUserId(@PathVariable int userId) {
        List<String> seatNumbers = bookingService.getSeatNumbersByUserId(userId);
        return ResponseEntity.ok(seatNumbers);
    }
}
