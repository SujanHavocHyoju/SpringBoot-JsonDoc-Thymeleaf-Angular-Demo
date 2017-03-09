package com.havoc.dao;

import com.havoc.model.HotelBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<HotelBooking, Integer> {

    List<HotelBooking> findByPricePerNightLessThan(double price);
}
