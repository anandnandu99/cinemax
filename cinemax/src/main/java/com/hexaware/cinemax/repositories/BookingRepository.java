// BookingRepository.java (Repository)
package com.hexaware.cinemax.repositories;

import com.hexaware.cinemax.entities.Booking;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

	List<Booking> findByShowId(int showId);
}
