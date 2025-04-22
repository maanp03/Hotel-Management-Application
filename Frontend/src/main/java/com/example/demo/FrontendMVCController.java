package com.example.demo;


//Maan and Areebah

import com.example.demo.Hotel;
import com.example.demo.Staff;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Controller
public class FrontendMVCController {

 private final RestTemplate restTemplate = new RestTemplate();

 @Value("${staff.service.url:http://localhost:8082/staff}")
 private String staffServiceUrl;

 @Value("${hotel.service.url:http://localhost:8081/hotels}")
 private String hotelServiceUrl;

 @GetMapping("/")
 public String viewStaff(Model model) {
     ResponseEntity<Staff[]> response = restTemplate.getForEntity(staffServiceUrl, Staff[].class);
     List<Staff> staffList = Arrays.asList(response.getBody());
     staffList.sort(Comparator.comparingInt(s -> List.of("Reception", "Cleaning", "Management", "Restaurant").indexOf(s.getDepartment())));
     model.addAttribute("staffList", staffList);
     return "home";
 }

 @GetMapping("/staff/new")
 public String showCreateForm(Model model) {
     model.addAttribute("staff", new Staff());
     model.addAttribute("hotels", getHotels());
     return "form";
 }

 @PostMapping("/staff/save")
 public String saveStaff(@ModelAttribute Staff staff) {
     HttpHeaders headers = new HttpHeaders();
     headers.setContentType(MediaType.APPLICATION_JSON);
     HttpEntity<Staff> request = new HttpEntity<>(staff, headers);

     if (staff.getStaffid() == 0) {
         restTemplate.postForObject(staffServiceUrl, request, Staff.class);
     } else {
         restTemplate.exchange(staffServiceUrl + "/" + staff.getStaffid(), HttpMethod.PUT, request, Staff.class);
     }
     return "redirect:/";
 }

 @GetMapping("/staff/edit/{id}")
 public String editStaff(@PathVariable int id, Model model) {
     Staff staff = restTemplate.getForObject(staffServiceUrl + "/" + id, Staff.class);
     model.addAttribute("staff", staff);
     model.addAttribute("hotels", getHotels());
     return "form";
 }

 @GetMapping("/staff/delete/{id}")
 public String deleteStaff(@PathVariable int id) {
     restTemplate.delete(staffServiceUrl + "/" + id);
     return "redirect:/";
 }

 private List<Hotel> getHotels() {
     ResponseEntity<Hotel[]> response = restTemplate.getForEntity(hotelServiceUrl, Hotel[].class);
     return Arrays.asList(response.getBody());
 }
}
