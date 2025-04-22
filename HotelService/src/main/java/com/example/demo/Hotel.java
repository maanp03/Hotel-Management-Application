package com.example.demo;

//Maan and Areebah
import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;


@Entity
@Table(name = "HOTEL")
public class Hotel {

    @Id
    @Column(name = "HOTELID", length = 8)
    @Pattern(regexp = "^[A-Z][a-z]{3}[0-9]{4}$", message = "Hotel ID must follow pattern Xxxx1234")
    private String hotelid;

    @Column(name = "HOTELNAME", nullable = false)
    @NotBlank(message = "Hotel name is required")
    private String hotelname;

    @Column(name = "STARRATING")
    @Min(value = 1, message = "Star rating must be between 1 and 5")
    @Max(value = 5, message = "Star rating must be between 1 and 5")
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
