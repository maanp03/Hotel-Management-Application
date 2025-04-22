package com.example.demo;

//Maan and Areebah

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/staff")
@Validated
public class StaffController {

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private HotelRepository hotelRepository;

  
    private final List<String> departmentOrder = List.of("Reception", "Cleaning", "Management", "Restaurant");

    // GET all staff
    @GetMapping
    public List<Staff> getAllStaff() {
        return staffRepository.findAll().stream()
                .sorted(Comparator.comparingInt(staff -> departmentOrder.indexOf(staff.getDepartment())))
                .collect(Collectors.toList());
    }

    // GET by id
    @GetMapping("/{id}")
    public ResponseEntity<Staff> getStaffById(@PathVariable int id) {
        Optional<Staff> staff = staffRepository.findById(id);
        return staff.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // POST - create staff 
    @PostMapping
    public ResponseEntity<?> createStaff(@RequestBody @Valid Staff staff) {
        Hotel hotel = hotelRepository.findById(staff.getHotel().getHotelid()).orElse(null);

        if (hotel == null) {
            return ResponseEntity.badRequest().body("Hotel does not exist.");
        }

        if (staff.getPerformancerating() >= 4 && hotel.getStarrating() < 4) {
            return ResponseEntity.badRequest().body("Staff with rating >= 4 must be assigned to hotel with star rating >= 4.");
        }

       
        if (staff.getPerformancerating() == 0) {
            staff.setPerformancerating(3);
        }

        staff.setHotel(hotel); 
        return ResponseEntity.ok(staffRepository.save(staff));
    }

    // PUT - update staff
    @PutMapping("/{id}")
    public ResponseEntity<?> updateStaff(@PathVariable int id, @RequestBody @Valid Staff updatedStaff) {
        Optional<Staff> optionalStaff = staffRepository.findById(id);
        if (optionalStaff.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Staff staff = optionalStaff.get();
        Hotel hotel = hotelRepository.findById(updatedStaff.getHotel().getHotelid()).orElse(null);

        if (hotel == null) {
            return ResponseEntity.badRequest().body("Hotel does not exist.");
        }

        if (updatedStaff.getPerformancerating() >= 4 && hotel.getStarrating() < 4) {
            return ResponseEntity.badRequest().body("Staff with rating >= 4 must be assigned to hotel with star rating >= 4.");
        }

        staff.setStaffname(updatedStaff.getStaffname());
        staff.setDepartment(updatedStaff.getDepartment());
        staff.setPerformancerating(updatedStaff.getPerformancerating());
        staff.setHotel(hotel);

        return ResponseEntity.ok(staffRepository.save(staff));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStaff(@PathVariable int id) {
        if (staffRepository.existsById(id)) {
            staffRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

