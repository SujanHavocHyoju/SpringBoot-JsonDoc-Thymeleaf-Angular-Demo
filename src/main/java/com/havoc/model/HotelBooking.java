package com.havoc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HotelBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String hotelName;
    private double pricePerNight;
    private int numOfNights;

    public HotelBooking() {
    }

    public HotelBooking(int id, String hotelName, double pricePerNight, int numOfNights) {
        this.id = id;
        this.hotelName = hotelName;
        this.pricePerNight = pricePerNight;
        this.numOfNights = numOfNights;
    }

    public HotelBooking(String hotelName, double pricePerNight, int numOfNights) {
        this.hotelName = hotelName;
        this.pricePerNight = pricePerNight;
        this.numOfNights = numOfNights;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public int getNumOfNights() {
        return numOfNights;
    }

    public void setNumOfNights(int numOfNights) {
        this.numOfNights = numOfNights;
    }

    public double getFinalPrice(){
        return pricePerNight * numOfNights;
    }
}

