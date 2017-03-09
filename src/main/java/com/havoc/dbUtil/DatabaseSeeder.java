package com.havoc.dbUtil;

import com.havoc.dao.BookingRepository;
import com.havoc.model.HotelBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private BookingRepository bookingRepository;

    @Autowired
    public DatabaseSeeder(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        List<HotelBooking> bookings = new ArrayList<>();

        bookings.add(new HotelBooking("Mirabel",5000,2));
        bookings.add(new HotelBooking("Dhilikhel Resort",4000,3));
        bookings.add(new HotelBooking("Mountail View",3000,4));

        bookingRepository.save(bookings);
    }
}
