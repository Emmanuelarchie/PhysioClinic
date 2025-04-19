/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.physioapp;
import java.time.LocalTime;
/**
 *
 * @author emman
 */
public class Appointment {
    
     String treatmentName; 
     LocalTime time; 
     Patient patient; 
     String status; // booked, cancelled, attended
     
     public Appointment(String treatmentName, LocalTime time) {
    this.treatmentName = treatmentName;
    this.time = time;
    this.status = "available";
     }
     
     public void book(Patient patient) {
    if (this.status.equals("available")) {
        this.patient = patient;
        this.status = "booked";
    }
     
     
     }
     
     
     public void cancel() {
    if (this.status.equals("booked")) {
        this.patient = null;
        this.status = "cancelled";
    }
}

public void attend() {
    if (this.status.equals("booked")) {
        this.status = "attended";
    }
}
     
}


