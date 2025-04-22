package com.example.demo;

//Maan and Areebah


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {
   
}
