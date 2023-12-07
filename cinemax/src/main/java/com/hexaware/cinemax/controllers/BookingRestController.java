// BookingRestController.java (Controller)
package com.hexaware.cinemax.controllers;

import com.hexaware.cinemax.dto.BookingDTO;
import com.hexaware.cinemax.services.IBookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingRestController {

    @Autowired
    private IBookingService bookingService;

    @PostMapping
    public ResponseEntity<Void> bookSeat(@RequestBody BookingDTO bookingDTO) {
        bookingService.bookSeat(bookingDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Other methods for updating bookings, retrieving bookings by ID, etc.
}
