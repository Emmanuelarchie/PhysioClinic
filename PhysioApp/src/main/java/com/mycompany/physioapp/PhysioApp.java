/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.physioapp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

/**
 *
 * @author emman
 */
public class PhysioApp {

    public static void main(String[] args) {
        
        Clinic clinic = new Clinic();       
        
        // Create physiotherapists
    Physiotherapist physio1 = new Physiotherapist("John Kuka", "Physical Therapy");
    Physiotherapist physio2 = new Physiotherapist("Jamil James", "Massage Therapy");
    Physiotherapist physio3 = new Physiotherapist("Bob Johnson", "Chiropractic");
    
    clinic.addPhysiotherapist(physio1);
    clinic.addPhysiotherapist(physio2);
    clinic.addPhysiotherapist(physio3);
    
    // Creating patients
    Patient patient1 = new Patient("Rebecca Brown");
    Patient patient2 = new Patient("Emman Wilther");
    Patient patient3 = new Patient("Tunde Gaske");
    Patient patient4 = new Patient("Shun Michael");
    Patient patient5 = new Patient("Charlie Wilson");
    Patient patient6 = new Patient("Bola Rita");
    Patient patient7 = new Patient("Chucks Kaka");
    Patient patient8 = new Patient("Obi Nelson");
    Patient patient9 = new Patient("Jerry Rolla");
    Patient patient10 = new Patient("Diana Miller");
    
     clinic.addPatient(patient1);
    clinic.addPatient(patient2);
    clinic.addPatient(patient3);
    clinic.addPatient(patient4);
    clinic.addPatient(patient5);
    clinic.addPatient(patient6);
    clinic.addPatient(patient7);
    clinic.addPatient(patient8);
    clinic.addPatient(patient9);
    clinic.addPatient(patient10);
    
     // Create appointments
    LocalDate week1 = LocalDate.of(2023, 10, 1);
    LocalDate week2 = LocalDate.of(2023, 10, 8);
    LocalDate week3 = LocalDate.of(2023, 10, 15);
    LocalDate week4 = LocalDate.of(2023, 10, 22);
    
    
    // Add appointments for physio1
    physio1.timetable.addAppointment(week1, new Appointment("Physical Therapy Session", LocalTime.of(9, 0)));
    physio1.timetable.addAppointment(week1, new Appointment("Physical Therapy Session", LocalTime.of(10, 0)));
    physio1.timetable.addAppointment(week2, new Appointment("Physical Therapy Session", LocalTime.of(11, 0)));
    
    
    
    // Example usage:
    Scanner scanner = new Scanner(System.in);
    while (true) {
        System.out.println("\n 1. Book by Expertise");
        System.out.println("2. Book by Physiotherapist");
        System.out.println("3. Cancel Appointment");
        System.out.println("4. Generate Report");
        System.out.println("5. Exit");
        
        System.out.print("Choose an option: ");
        int option = Integer.parseInt(scanner.nextLine());

        switch (option) {
            case 1 -> {
                System.out.print("Enter expertise: ");
                String expertise = scanner.nextLine();
                System.out.print("Enter date (yyyy-MM-dd): ");
                LocalDate date = LocalDate.parse(scanner.nextLine());
                System.out.print("Enter time (HH:mm): ");
                LocalTime time = LocalTime.parse(scanner.nextLine());
                System.out.print("Enter patient name: ");
                
                String patientName = scanner.nextLine();
               
                Patient patient = (Patient) clinic.patients.stream()
                        .filter(p -> p.equals(patientName))
                        .findFirst()
                        .orElse(null);
                if (patient != null) {
                    clinic.bookAppointmentByExpertise(expertise, patient, date, time);
                } else {
                    System.out.println("Patient not found!");
                }
                }
            case 2 -> {
                System.out.print("Enter physiotherapist name: ");
                String physioName = scanner.nextLine();
                System.out.print("Enter date (yyyy-MM-dd): ");
                LocalDate date2 = LocalDate.parse(scanner.nextLine());
                System.out.print("Enter time (HH:mm): ");
                LocalTime time2 = LocalTime.parse(scanner.nextLine());
                System.out.print("Enter patient name: ");
                String patientName2 = scanner.nextLine();
                
                patient1 = (Patient)clinic.patients.stream()
                        .filter(p -> p.equals(patientName2))
                        .findFirst()
                        .orElse(null);
                if (patient1 != null) {
                    clinic.bookAppointmentByPhysiotherapist(physioName, patient2, date2, time2);
                } else {
                    System.out.println("Patient not found!");
                }
                }
                
            case 3 -> {
                System.out.print("Enter patient name: ");
                String patientName3 = scanner.nextLine();
                patient3 = (Patient) clinic.patients.stream()
                        .filter(p -> p.equals(patientName3))
                        .findFirst()
                        .orElse(null);
                if (patient3 != null) {
                    System.out.print("Enter date (yyyy-MM-dd): ");
                    LocalDate date3 = LocalDate.parse(scanner.nextLine());
                    System.out.print("Enter time (HH:mm): ");
                    LocalTime time3 = LocalTime.parse(scanner.nextLine());
                    clinic.cancelAppointment(patient3, date3, time3);
                } else {
                    System.out.println("Patient not found!");
                }
                }
            case 4 -> clinic.generateReport();
            case 5 -> System.exit(0);
            default -> System.out.println("Invalid option. Please choose again.");
        }
    }
}
}
