 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.physioapp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author emman
 */
public class Timetable {
    Map<LocalDate, List> appointments;
    
    public Timetable() {
     this.appointments = new HashMap<>();
   }
    
    public void addAppointment( LocalDate date, Appointment appointment)
    {
        if (!appointments.containsKey(date)) {
            appointments.put(date, new ArrayList<>());
        }
        appointments.get(date).add(appointment);
        
    }
    
    public List<Appointment> getAppointment(LocalDate date){
        return appointments.getOrDefault(date, new ArrayList<>());
    }
    
}
 
