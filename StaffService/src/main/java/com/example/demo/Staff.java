package com.example.demo;

//Maan and Areebah

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "STAFF")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STAFFID")
    private int staffid;

    @Column(name = "STAFFNAME", nullable = false)
    @NotBlank(message = "Staff name is required")
    private String staffname;

    @Column(name = "DEPARTMENT")
    private String department;

    @Column(name = "PERFORMANCERATING")
    @Min(value = 1, message = "Performance rating must be between 1 and 5")
    @Max(value = 5, message = "Performance rating must be between 1 and 5")
    private int performancerating = 3;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HOTELID", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Hotel hotel;

    // Getters and Setters

    public int getStaffid() {
        return staffid;
    }

    public void setStaffid(int staffid) {
        this.staffid = staffid;
    }

    public String getStaffname() {
        return staffname;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getPerformancerating() {
        return performancerating;
    }

    public void setPerformancerating(int performancerating) {
        this.performancerating = performancerating;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
