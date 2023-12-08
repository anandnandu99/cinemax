// ISeatService.java (Service)
package com.hexaware.cinemax.services;

import java.util.List;

public interface ISeatService {
    List<String> getAvailableSeats(int showId);
    List<String> getBookedSeats(int showId);
    // Other service methods

    // ...
}
