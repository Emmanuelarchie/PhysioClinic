/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.physioapp;

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
         
       
        
        // TODO review the generated test code and remove the default call to fail.        fail("The test case is a prototype.");
    }
    


    /**
     * Test of getPatientByName method, of class Clinic.
     */
    @org.junit.jupiter.api.Test
    public void testGetPatientByName() {
        System.out.println("getPatientByName");
        String name = "";
        Clinic instance = new Clinic();
        Patient expResult = null;
        Patient result = instance.getPatientByName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of addPhysiotherapist method, of class Clinic.
     */
    @org.junit.jupiter.api.Test
    public void testAddPhysiotherapist() {
        System.out.println("addPhysiotherapist");
        Physiotherapist physio = null;
        Clinic instance = new Clinic();
        instance.addPhysiotherapist(physio);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of addPatient method, of class Clinic.
     */
    @org.junit.jupiter.api.Test
    public void testAddPatient() {
        System.out.println("addPatient");
        Patient newPatient = null;
        Clinic instance = new Clinic();
        boolean expResult = false;
        boolean result = instance.addPatient(newPatient);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of removePatient method, of class Clinic.
     */
    @org.junit.jupiter.api.Test
    public void testRemovePatient() {
        System.out.println("removePatient");
        Patient patient = null;
        Clinic instance = new Clinic();
        instance.removePatient(patient);
        // TODO review the generated test code and remove the default call to fail.
    
    }

    /**
     * Test of bookAppointmentByExpertise method, of class Clinic.
     */
    @org.junit.jupiter.api.Test
    public void testBookAppointmentByExpertise() {
        System.out.println("bookAppointmentByExpertise");
        String expertise = "";
        Patient patient = null;
        LocalDate date = null;
        LocalTime time = null;
        Clinic instance = new Clinic();
        instance.bookAppointmentByExpertise(expertise, patient, date, time);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of bookAppointmentByphysiotherapist method, of class Clinic.
     */
    @org.junit.jupiter.api.Test
    public void testBookAppointmentByphysiotherapist() {
        System.out.println("bookAppointmentByphysiotherapist");
        String physioName = "";
        Patient patient = null;
        LocalDate date = null;
        LocalTime time = null;
        Clinic instance = new Clinic();
        instance.bookAppointmentByphysiotherapist(physioName, patient, date, time);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cancelAppointment method, of class Clinic.
     */
    @org.junit.jupiter.api.Test
    public void testCancelAppointment() {
        System.out.println("cancelAppointment");
        Patient patient = null;
        LocalDate date = null;
        LocalTime time = null;
        Clinic instance = new Clinic();
        instance.cancelAppointment(patient, date, time);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of attendAppointment method, of class Clinic.
     */
    @org.junit.jupiter.api.Test
    public void testAttendAppointment() {
        System.out.println("attendAppointment");
        Patient patient = null;
        LocalDate date = null;
        LocalTime time = null;
        Clinic instance = new Clinic();
        instance.attendAppointment(patient, date, time);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of generateReport method, of class Clinic.
     */
    @org.junit.jupiter.api.Test
    public void testGenerateReport() {
        System.out.println("generateReport");
        Clinic instance = new Clinic();
        instance.generateReport(); } }
        // TODO review the generated test code and remove the default call to fail.
    
    



  