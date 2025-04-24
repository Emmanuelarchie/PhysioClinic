/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.physioapp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class Clinic {
    List<Physiotherapist> physiotherapist;
    List<Patient> patients;

    public List<Patient> getAllPatients() {
        return new ArrayList<>(this.patients);
    }

    public Clinic() {
        this.physiotherapist = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public Patient getPatientByName(String name) {
        for (Patient patient : patients) {
            if (patient.getName().equalsIgnoreCase(name)) {
                return patient;
            }
        }
        return null;
    }

    public void addPhysiotherapist(Physiotherapist physio) {
        physiotherapist.add(physio);
    }

    public boolean addPatient(Patient newPatient) {
        for (Patient p : patients) {
            if (p.getName().equalsIgnoreCase(newPatient.getName())
                    && p.getPhoneNumber().equals(newPatient.getPhoneNumber())) {
                System.out.println("Patient already added.");
                return false;
            }
        }
        patients.add(newPatient);
        return true;
    }

    public void removePatient(Patient patient) {
        patients.remove(patient);
    }

    public void bookAppointmentByExpertise(String expertise, Patient patient, LocalDate date, LocalTime time) {
        for (Physiotherapist physio : physiotherapist) {
            if (physio.expertise.equalsIgnoreCase(expertise)) {
                for (Appointment appointment : physio.timetable.getAppointment(date)) {
                    if (appointment.time.equals(time) && appointment.status.equals("available")) {
                        appointment.book(patient);
                        System.out.println("Appointment booked successfully!");
                        return;
                    }
                }
            }
        }
        System.out.println("No available appointment found for the given expertise and time.");
    }

    public void bookAppointmentByphysiotherapist(String physioName, Patient patient, LocalDate date, LocalTime time) {
        for (Physiotherapist physio : physiotherapist) {
            if (physio.name.equalsIgnoreCase(physioName)) {
                for (Appointment appointment : physio.timetable.getAppointment(date)) {
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
        for (Physiotherapist physio : physiotherapist) {
            for (Appointment appointment : physio.timetable.getAppointment(date)) {
                if (appointment.time.equals(time)
                        && appointment.patient != null
                        && appointment.patient.equals(patient)) {
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
        for (Physiotherapist physio : physiotherapist) {
            System.out.println("\nPhysiotherapist: " + physio.name);
            for (LocalDate date : physio.timetable.appointments.keySet()) {
                List<Appointment> appointmentsList = physio.timetable.appointments.get(date);
                for (int j = 0; j < appointmentsList.size(); j++) {
                    Appointment appointment = appointmentsList.get(j);
                    System.out.println("Date: " + date + ", Treatment: " + appointment.treatmentName +
                            ", Time: " + appointment.time +
                            ", Patient: " + (appointment.patient != null ? appointment.patient.getName() : "None") +
                            ", Status: " + appointment.status);
                }
            }
        }

        System.out.println("\n--- Physiotherapist Performance ---");
        Map<Physiotherapist, Integer> attendedCount = new HashMap<>();

        for (Physiotherapist physio : physiotherapist) {
            int count = 0;
            for (List<Appointment> appointmentList : physio.timetable.appointments.values()) {
                for (Appointment appointment : appointmentList) {
                    if ("attended".equalsIgnoreCase(appointment.status)) {
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
