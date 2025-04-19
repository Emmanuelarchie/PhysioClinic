/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.physioapp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author emman
 */
public class Clinic { List physiotherapists; 
    List patients;
    
    
    public Clinic() {
    this.physiotherapists = new ArrayList<>();
    this.patients = new ArrayList<>();
}
 
    
    public void addPhysiotherapist(Physiotherapist physio) {
    physiotherapists.add(physio);
}
    
    
    public void addPatient(Patient patient) {
    patients.add(patient);
}
    
    public void removePatient(Patient patient) {
    patients.remove(patient);
}
    
    public void bookAppointmentByExpertise(String expertise, Patient patient, LocalDate date, LocalTime time) {
   // for (Physiotherapist physio : physiotherapists) {
for(int i = 0; i <physiotherapists.size(); i++)
{      
    Physiotherapist physio = (Physiotherapist) physiotherapists.get(i); 
if (physio.expertise.equals(expertise)) {
            for (Appointment appointment : physio.timetable.getAppointments(date)) {
                if (appointment.time.equals(time) && appointment.status.equals("available")) {
                    appointment.book(patient);
                    System.out.println("Appointment booked successfully!");
                    return;
                }
                else{
                    System.out.println("Appointment NOT  booked successfully!");
                    return;
                }
            }
        }
    }
    System.out.println("No available appointment found for the given expertise and time.");
}
    
 public void bookAppointmentByPhysiotherapist(String physioName, Patient patient, LocalDate date, LocalTime time) {
   // for (Physiotherapist physio : physiotherapists.get(i)) {
     
for(int i = 0; i <physiotherapists.size(); i++)
{   
     Physiotherapist physio = (Physiotherapist) physiotherapists.get(i);
if (physio.name.equals(physioName)) {
            for (Appointment appointment : physio.timetable.getAppointments(date)) {
                if (appointment.time.equals(time) && appointment.status.equals("available")) {
                    appointment.book(patient);
                    System.out.println("Appointment booked successfully!");
                    return;
                }
            }
        }
    }
    System.out.println("No available appointment found for the given physiotherapist and time.");
}

 
 public void cancelAppointment(Patient patient, LocalDate date, LocalTime time) {
   // for (Physiotherapist physio : physiotherapists) {
for(int i = 0; i <physiotherapists.size(); i++)
{
 Physiotherapist physio = (Physiotherapist) physiotherapists.get(i);
        for (Appointment appointment : physio.timetable.getAppointments(date)) {
            if (appointment.time.equals(time) && appointment.patient != null && appointment.patient.equals(patient)) {
                appointment.cancel();
                System.out.println("Appointment cancelled successfully!");
                return;
            }
        }
    }
    System.out.println("No appointment found for the given patient and time.");
}
    
  
 public void generateReport() {
    System.out.println("\n--- Appointment Report ---");
    //for (Physiotherapist physio : physiotherapists) {
    for(int i = 0; i <physiotherapists.size(); i++)
{
    Physiotherapist physio = (Physiotherapist) physiotherapists.get(i);
        System.out.println("\nPhysiotherapist: " + physio.name);
        for (LocalDate date : physio.timetable.appointments.keySet()) {
            //for (Appointment appointment : physio.timetable.appointments.get(date)) {
             List appointmentsList = physio.timetable.appointments.get(date); 
             for (i = 0; i < appointmentsList.size(); i++) {
                 
                Appointment appointment = (Appointment)appointmentsList.get(i); 
                System.out.println("Treatment: " + appointment.treatmentName +
                                   ", Time: " + appointment.time +
                                   ", Patient: " + (appointment.patient != null ? appointment.patient.getName() : "None") +
                                   ", Status: " + appointment.status);
            }
        }
    }

    System.out.println("\n--- Physiotherapist Performance ---");
    Map<Physiotherapist, Integer> attendedCount = new HashMap<>();
   // for (Physiotherapist physio : physiotherapists) {
       for(int i = 0; i <physiotherapists.size(); i++)
{ 
    Physiotherapist physio = (Physiotherapist) physiotherapists.get(i);
        
        int count = 0;
        for (LocalDate date : physio.timetable.appointments.keySet()) {
           // for (Appointment appointment : physio.timetable.appointments.get(date)) {
           
           List appointmentsList = physio.timetable.appointments.get(date); 
           for (i = 0; i < appointmentsList.size(); i++) { 
               Appointment appointment =(Appointment)appointmentsList.get(i);
                if (appointment.status.equals("attended")) {
                    count++;
                }
            }
        }
        attendedCount.put(physio, count);
    }

    attendedCount.entrySet().stream()
                 .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                 .forEach(entry -> System.out.println(entry.getKey().name + ": " + entry.getValue() + " attended appointments"));
}
 
    
}
