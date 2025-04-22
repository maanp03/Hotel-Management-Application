package com.example.demo;

//MAAN AND AREEBAH


public class Staff {
 private int staffid;
 private String staffname;
 private String department;
 private int performancerating;
 private Hotel hotel;

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