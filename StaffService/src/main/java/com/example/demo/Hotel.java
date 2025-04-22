package com.example.demo;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
//Maan and Areebah
@Entity
@Table(name = "HOTEL")
public class Hotel {

    @Id
    @Column(name = "HOTELID", length = 8)
    private String hotelid;

    @Column(name = "HOTELNAME", nullable = false)
    private String hotelname;

    @Column(name = "STARRATING")
    private int starrating;

    // Getters and Setters

    public String getHotelid() {
        return hotelid;
    }

    public void setHotelid(String hotelid) {
        this.hotelid = hotelid;
    }

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname;
    }

    public int getStarrating() {
        return starrating;
    }

    public void setStarrating(int starrating) {
        this.starrating = starrating;
    }
}
