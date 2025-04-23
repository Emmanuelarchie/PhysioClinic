/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.physioapp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhysioApp {

    public static void main(String[] args) {

        Clinic clinic = new Clinic();
        Scanner scanner = new Scanner(System.in);
        List<Patient> patientList = new ArrayList<>();

        // Reusable patient variable
        Patient patient = null;

        // Create physiotherapists
        Physiotherapist physio1 = new Physiotherapist("John Kuka", "Physical Therapy");
        Physiotherapist physio2 = new Physiotherapist("Jamil James", "Massage Therapy");
        Physiotherapist physio3 = new Physiotherapist("Bob Johnson", "Chiropractic");

        clinic.addPhysiotherapist(physio1);
        clinic.addPhysiotherapist(physio2);
        clinic.addPhysiotherapist(physio3);

        // Creating and adding patients
        clinic.addPatient(new Patient("Rebecca Brown", "08023306584", "1 Ibiono Lane, uyo"));
        clinic.addPatient(new Patient("Emman Wilther", "08023248007", "141 Nkemba street, uyo"));
        clinic.addPatient(new Patient("Tunde Gaske", "09099887766", "23 Awolowo Road, Ikoyi"));
        clinic.addPatient(new Patient("Shun Michael", "08137618129", "14 Maclean court, Delta"));
        clinic.addPatient(new Patient("Charlie Wilson", "07034686587", "12 alikepli road ,Bayelsa"));
        clinic.addPatient(new Patient("Bola Rita", "08036758146", "45 reala road, Ondo"));
        clinic.addPatient(new Patient("Chucks Kaka", "08045283530", "32 biga road , Sokoto"));
        clinic.addPatient(new Patient("Obi Nelson", "07777348655", "7 Newton Court, Hatfield"));
        clinic.addPatient(new Patient("Jerry Rolla", "080211911345", "8 Osongama street , uyo"));
        clinic.addPatient(new Patient("Diana Miller", "0904589276", "11 mitama street,Ewet housing"));

        // Add a new patient interactively
        System.out.println("Add a new patient");
        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();

        System.out.print("Enter address: ");
        String address = scanner.nextLine();

        //Check if the patient already exists
        Patient existingPatient = clinic.getPatientByName(name);
        if (existingPatient != null) {
            System.out.println("Patient already exist in the clinic.");
            patient = existingPatient;
        } else {
            patient = new Patient( name, phone, address);
            clinic.addPatient(patient);
            System.out.println( "Patient added successfully");
        }
       //show all patients
       System.out.println("\nCurrent Patients in the clinic:");
       for (Patient p : clinic.getAllPatients()) {
           System.out.println("-" + p.getName() + " | " + p.getPhoneNumber() + " | " + p.getAddress());
       }


        // Add appointments for physio1
        LocalDate week1 = LocalDate.of(2023, 10, 1);
        LocalDate week2 = LocalDate.of(2023, 10, 8);

        physio1.timetable.addAppointment(week1, new Appointment("Physical Therapy Session", LocalTime.of(9, 0)));
        physio1.timetable.addAppointment(week1, new Appointment("Physical Therapy Session", LocalTime.of(10, 0)));
        physio1.timetable.addAppointment(week2, new Appointment("Physical Therapy Session", LocalTime.of(11, 0)));

        // Menu loop
        while (true) {
            System.out.println("\n1. Book by Expertise");
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
                    System.out.print("Enter date (yyyy-MM-dd):");
                    LocalDate date = LocalDate.parse(scanner.nextLine());
                    System.out.print("Enter time (HH:mm): ");
                    LocalTime time = LocalTime.parse(scanner.nextLine());
                    System.out.print("Enter patient name: ");
                    String patientName = scanner.nextLine();

                    patient = clinic.getPatientByName(patientName);
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

                    patient = clinic.getPatientByName(patientName2);
                    if (patient != null) {
                        clinic.bookAppointmentByphysiotherapist(physioName, patient, date2, time2);
                    } else {
                        System.out.println("Patient not found!");
                    }
                }

                case 3 -> {
                    System.out.print("Enter patient name: ");
                    String patientName3 = scanner.nextLine();

                    patient = clinic.getPatientByName(patientName3);
                    if (patient != null) {
                        System.out.print("Enter date (yyyy-MM-dd): ");
                        LocalDate date3 = LocalDate.parse(scanner.nextLine());
                        System.out.print("Enter time (HH:mm): ");
                        LocalTime time3 = LocalTime.parse(scanner.nextLine());
                        clinic.cancelAppointment(patient, date3, time3);
                    } else {
                        System.out.println("Patient not found!");
                    }
                }

                case 4 -> clinic.generateReport();

                case 5 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }

                default -> System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}
