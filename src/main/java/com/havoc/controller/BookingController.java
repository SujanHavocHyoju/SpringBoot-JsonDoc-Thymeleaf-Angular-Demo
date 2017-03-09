package com.havoc.controller;

import com.havoc.dao.BookingRepository;
import com.havoc.model.HotelBooking;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.pojo.ApiStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/bookings")
@Api(name = "HotelBookingAPI",
     description = "Demo Booking API",
     stage = ApiStage.RC)
public class BookingController {

    /*private List<HotelBooking> bookings;
    public BookingController() {
        bookings=new ArrayList<>();
        bookings.add(new HotelBooking("Mirabel",5000,2));
        bookings.add(new HotelBooking("Dhilikhel Resort",4000,3));
        bookings.add(new HotelBooking("Mountail View",3000,4));
    }*/

    private BookingRepository bookingRepository;

    @Autowired
    public BookingController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ApiMethod(description = "Get all records from db")
    public List<HotelBooking> getAll(){
        return bookingRepository.findAll();
        //return bookings;
    }

    @RequestMapping(value = "/affordable/{price}", method = RequestMethod.GET)
    @ApiMethod(description = "Get all records with price less than Rs.4000/-")
    public List<HotelBooking> getAffordable( @ApiPathParam(name = "price") @PathVariable double price){
        return bookingRepository.findByPricePerNightLessThan(price);
        //return bookings.stream().filter(x->x.getPricePerNight() <= price).collect(Collectors.toList());
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ApiMethod(description = "Create & Insert new Record in db")
    public List<HotelBooking> create(@RequestBody HotelBooking hotelBooking){
        bookingRepository.save(hotelBooking);
        return bookingRepository.findAll();
        /*bookings.add(hotelBooking);
        return bookings;*/
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ApiMethod(description = "Delete a record by provided id from db")
    public List<HotelBooking> remove(@ApiPathParam(name = "id") @PathVariable int id){
        bookingRepository.delete(id);
        return bookingRepository.findAll();
    }
}
