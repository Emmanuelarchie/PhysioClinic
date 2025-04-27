/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.physioapp;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author emman
 */
public class ClinicTest {
    
   
    /**
     * Test of getAllPatients method, of class Clinic.
     */
    @org.junit.jupiter.api.Test
    public void testGetAllPatients() {
        System.out.println("getAllPatients");
        Clinic instance = new Clinic();
        Patient expectedPatient = new Patient("Rebecca Brown", "08023306584", "1 Ibiono Lane, Uyo");
        instance.addPatient(expectedPatient);
        List<Patient> result = instance.getAllPatients();
        assertEquals(1, result.size());
        assertEquals(expectedPatient.getName(), result.get(0).getName());
        assertEquals(expectedPatient.getPhoneNumber(), result.get(0).getPhoneNumber());
        assertEquals(expectedPatient.getAddress(), result.get(0).getAddress());
         
       
        
       
    }
    


    /**
     * Test of getPatientByName method, of class Clinic.
     */
    @org.junit.jupiter.api.Test
    public void testGetPatientByName() {
        System.out.println("Get Patient By NAme");
        String name = "Emman Wilther";
        Clinic instance = new Clinic();
        Patient newP = new Patient("Emman Wilther","08023306584", "1 Ibiono Lane, Uyo");
        instance.addPatient(newP);
        Patient expResult = newP;
        Patient result = instance.getPatientByName(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of addPhysiotherapist method, of class Clinic.
     */
    @org.junit.jupiter.api.Test
    public void testAddPhysiotherapist() {
        System.out.println("addPhysiotherapist");
        Physiotherapist physio = new Physiotherapist("John Kuka", "Physical Therapy");
        Clinic instance = new Clinic();
        instance.addPhysiotherapist(physio);
        int exp =1;
        int result = instance.getPhysios().size();
        assertEquals(exp,result);
       
    }

    /**
     * Test of addPatient method, of class Clinic.
     */
    @org.junit.jupiter.api.Test
    public void testAddPatient() {
        System.out.println("addPatient");
        Patient newPatient = new Patient("Tunde Gaske", "09099887766", "23 Awolowo Road, Ikoyi");
        Clinic instance = new Clinic();
        boolean expResult = true;
        boolean result = instance.addPatient(newPatient);
        assertEquals(expResult, result);
    }

    /**
     * Test of removePatient method, of class Clinic.
     */
    @org.junit.jupiter.api.Test
    public void testRemovePatient() {
        System.out.println("removePatient");
        Patient patient = new Patient ("Jerry Rolla", "080211911345", "8 Osongama street, Uyo");
        Clinic instance = new Clinic();
        instance.addPatient(patient);
        int res1 = instance.getPatient().size();
        assertEquals(1, res1); 
        
        int expRes = 0;
        instance.removePatient(patient);
        int res2= instance.getPatient().size();  
        assertEquals(expRes, res2);
    }

    /**
     * Test of bookAppointmentByExpertise method, of class Clinic.
     */
    @org.junit.jupiter.api.Test
    public void testBookAppointmentByExpertise() {
        System.out.println("bookAppointmentByExpertise");

        // Test data
        String expertise = "Physical Therapy";
        Physiotherapist physio = new Physiotherapist("John Doe", expertise);
        Patient patient = new Patient("Jerry Rolla", "080211911345", "8 Osongama street, Uyo");
        LocalDate date = LocalDate.of(2025, 4, 28);  
        LocalTime time = LocalTime.of(10, 30);  // Example time

        Appointment appointment = new Appointment("surgery", time );
        physio.timetable.addAppointment(date, appointment);

        // Create Clinic instance
        Clinic clinic = new Clinic();
        clinic.addPhysiotherapist(physio);  
        clinic.addPatient(patient);

        // Book the appointment
        clinic.bookAppointmentByExpertise(expertise, patient, date, time);
        
        // Assert that the appointment status is updated to 'booked'
        assertEquals("booked", appointment.getStatus(), "The appointment status should be 'booked' after booking.");
    }
        
       
   

    /**
     * Test of bookAppointmentByphysiotherapist method, of class Clinic.
     */
    @org.junit.jupiter.api.Test
    public void testBookAppointmentByphysiotherapist() {
        // Test data
        String expertise = "Physical Therapy";
        Physiotherapist physio = new Physiotherapist("John Doe", expertise);
        Patient patient = new Patient("Jerry Rolla", "080211911345", "8 Osongama street, Uyo");
        LocalDate date = LocalDate.of(2025, 4, 28);  
        LocalTime time = LocalTime.of(10, 30);  // Example time

        Appointment appointment = new Appointment("surgery", time );
        physio.timetable.addAppointment(date, appointment);

        // Create Clinic instance
        Clinic clinic = new Clinic();
        clinic.addPhysiotherapist(physio);  
        clinic.addPatient(patient);

        // Book the appointment
        clinic.bookAppointmentByphysiotherapist("John Doe", patient, date, time);
        
        // Assert that the appointment status is updated to 'booked'
        assertEquals("booked", appointment.getStatus(), "The appointment status should be 'booked' after booking.");
    }

    /**
     * Test of cancelAppointment method, of class Clinic.
     */
    @org.junit.jupiter.api.Test
    public void testCancelAppointment() {
        System.out.println("cancelAppointment");
        String expertise = "Physical Therapy";
        Physiotherapist physio = new Physiotherapist("John Doe", expertise);
        Patient patient = new Patient("Jerry Rolla", "080211911345", "8 Osongama street, Uyo");
        LocalDate date = LocalDate.of(2025, 4, 28);  
        LocalTime time = LocalTime.of(10, 30);  // Example time

        Appointment appointment = new Appointment("surgery", time );
        physio.timetable.addAppointment(date, appointment);

        // Create Clinic instance
        Clinic clinic = new Clinic();
        clinic.addPhysiotherapist(physio);  
        clinic.addPatient(patient);

        // Book the appointment
        clinic.bookAppointmentByphysiotherapist("John Doe", patient, date, time);
        
        
        
        clinic.cancelAppointment(patient, date, time);
        assertEquals("cancelled", appointment.getStatus(), "The appointment status should be 'cancelled' after booking.");
    }

    /**
     * Test of attendAppointment method, of class Clinic.
     */
    @org.junit.jupiter.api.Test
    public void testAttendAppointment() {
        System.out.println("attendAppointment");
           String expertise = "Physical Therapy";
        Physiotherapist physio = new Physiotherapist("John Doe", expertise);
        Patient patient = new Patient("Jerry Rolla", "080211911345", "8 Osongama street, Uyo");
        LocalDate date = LocalDate.of(2025, 4, 28);  
        LocalTime time = LocalTime.of(10, 30);  // Example time

        Appointment appointment = new Appointment("surgery", time );
        physio.timetable.addAppointment(date, appointment);

        // Create Clinic instance
        Clinic clinic = new Clinic();
        clinic.addPhysiotherapist(physio);  
        clinic.addPatient(patient);

        // Book the appointment
        clinic.bookAppointmentByphysiotherapist("John Doe", patient, date, time);
        
        
        clinic.attendAppointment(patient, date, time);
        assertEquals("attended", appointment.getStatus(), "The appointment status should be 'attended' after booking.");
        
        
    }

    /**
     * Test of generateReport method, of class Clinic.
     */
    @org.junit.jupiter.api.Test
    public void testGenerateReport() {
        // Capture the console output to verify the report
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);  // Redirecting System.out to capture the output

        // Create test data
        Patient patient1 = new Patient("Jerry Rolla", "080211911345", "8 Osongama street, Uyo");
        Patient patient2 = new Patient("Alice White", "080211911346", "7 Osongama street, Uyo");

        Physiotherapist physio1 = new Physiotherapist("Dr. John Doe", "Physical Therapy");
        Physiotherapist physio2 = new Physiotherapist("Dr. Jane Smith", "Chiropractic");

        Appointment appointment1 = new Appointment("Physical Therapy", LocalTime.of(10, 30));
        Appointment appointment2 = new Appointment("Physical Therapy", LocalTime.of(11, 30));
        Appointment appointment3 = new Appointment("Chiropractic", LocalTime.of(9, 00)  );

        // Create Timetables and add appointments
        Timetable timetable1 = new Timetable();
        timetable1.addAppointment(LocalDate.of(2025, 4, 28), appointment1);
        timetable1.addAppointment(LocalDate.of(2025, 4, 28), appointment2);
        
        Timetable timetable2 = new Timetable();
        timetable2.addAppointment(LocalDate.of(2025, 4, 29), appointment3);

        // Create Clinic instance and add physiotherapists
        Clinic clinic = new Clinic();
        clinic.addPhysiotherapist(physio1);
        clinic.addPhysiotherapist(physio2);
        clinic.addPatient(patient1);
        clinic.addPatient(patient2);

        // Call the generateReport method
        clinic.generateReport();

        // Capture the output and assert the expected content
        String reportOutput = outputStream.toString();
        
        // Check for expected content in the report
        assertTrue(reportOutput.contains("Physiotherapist: Dr. John Doe"));
        assertTrue(reportOutput.contains("Physiotherapist: Dr. Jane Smith"));

    }
}
        
    
    



  