package com.mycompany.physioapp;



import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.*;

public class PhysioApp {
    public static void main(String[] args) {
        Clinic clinic = new Clinic();
        Scanner scanner = new Scanner(System.in);
        Patient patient;

        // Create physiotherapists
        Physiotherapist physio1 = new Physiotherapist("John Kuka", "Physical Therapy");
        Physiotherapist physio2 = new Physiotherapist("Jamil James", "Massage Therapy");
        Physiotherapist physio3 = new Physiotherapist("Bob Johnson", "Chiropractic");

        clinic.addPhysiotherapist(physio1);
        clinic.addPhysiotherapist(physio2);
        clinic.addPhysiotherapist(physio3);

        // Add existing patients
        clinic.addPatient(new Patient("Rebecca Brown", "08023306584", "1 Ibiono Lane, Uyo"));
        clinic.addPatient(new Patient("Emman Wilther", "08023248007", "141 Nkemba street, Uyo"));
        clinic.addPatient(new Patient("Tunde Gaske", "09099887766", "23 Awolowo Road, Ikoyi"));
        clinic.addPatient(new Patient("Shun Michael", "08137618129", "14 Maclean court, Delta"));
        clinic.addPatient(new Patient("Charlie Wilson", "07034686587", "12 alikepli road, Bayelsa"));
        clinic.addPatient(new Patient("Bola Rita", "08036758146", "45 reala road, Ondo"));
        clinic.addPatient(new Patient("Chucks Kaka", "08045283530", "32 biga road, Sokoto"));
        clinic.addPatient(new Patient("Obi Nelson", "07777348655", "7 Newton Court, Hatfield"));
        clinic.addPatient(new Patient("Jerry Rolla", "080211911345", "8 Osongama street, Uyo"));
        clinic.addPatient(new Patient("Diana Miller", "0904589276", "11 Mitama street, Ewet housing"));

        // Add a new patient interactively
        System.out.println("Add a new patient");
        System.out.print("Enter patient name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine().trim();
        System.out.print("Enter address: ");
        String address = scanner.nextLine().trim();

        if (!name.isEmpty() && !phone.isEmpty() && !address.isEmpty()) {
            patient = new Patient(name, phone, address);
            boolean added = clinic.addPatient(patient);
            if (added) {
                System.out.println("Patient added successfully.");
            } else {
                System.out.println("Patient already exists in the clinic.");
                patient = clinic.getPatientByName(name);
            }
        } else {
            System.out.println("Invalid input. Name, phone number, and address cannot be empty.");
        }

        System.out.println("\n--- Current Patients in the Clinic ---");
        for (Patient p : clinic.getAllPatients()) {
            System.out.println(p.getName() + " | " + p.getPhoneNumber() + " | " + p.getAddress());
        }

        // Setup appointments
        LocalDate[] weeks = {
            LocalDate.of(2023, 10, 1),
            LocalDate.of(2023, 10, 8),
            LocalDate.of(2023, 10, 15),
            LocalDate.of(2023, 10, 22)
        };

        physio1.timetable.addAppointment(weeks[0], new Appointment("Neurological Physiotherapy Session", LocalTime.of(9, 0)));
        physio1.timetable.addAppointment(weeks[1], new Appointment("Sports physiotherapy Session", LocalTime.of(10, 0)));
        physio1.timetable.addAppointment(weeks[2], new Appointment("Physical Therapy Session", LocalTime.of(11, 0)));
        physio1.timetable.addAppointment(weeks[3], new Appointment("Physical Therapy Session", LocalTime.of(12, 0)));

        physio2.timetable.addAppointment(weeks[0], new Appointment("Neurological Physiotherapy Session", LocalTime.of(9, 0)));
        physio2.timetable.addAppointment(weeks[1], new Appointment("Cardiothoracic physiotherapy Session", LocalTime.of(10, 0)));
        physio2.timetable.addAppointment(weeks[2], new Appointment("Physical Therapy Session", LocalTime.of(11, 0)));
        physio2.timetable.addAppointment(weeks[3], new Appointment("Physical Therapy Session", LocalTime.of(12, 0)));

        physio3.timetable.addAppointment(weeks[0], new Appointment("Neurological Physiotherapy Session", LocalTime.of(9, 0)));
        physio3.timetable.addAppointment(weeks[1], new Appointment("Sports physiotherapy Session", LocalTime.of(10, 0)));
        physio3.timetable.addAppointment(weeks[3], new Appointment("Musculoskeletal Therapy Session", LocalTime.of(12, 0)));

        // Main menu loop
        while (true) {
            System.out.println("\n1. Book by Expertise");
            System.out.println("2. Book by Physiotherapist");
            System.out.println("3. Cancel Appointment");
            System.out.println("4. Generate Report");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            String input = scanner.nextLine();
            int option;

            try {
                option = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a number between 1 and 5.");
                continue;
            }

            switch (option) {
                case 1 -> {
                    System.out.print("Enter expertise: ");
                    String expertise = scanner.nextLine();
                    LocalDate date;
                    LocalTime time;
                    try {
                        System.out.print("Enter date (yyyy-MM-dd): ");
                        date = LocalDate.parse(scanner.nextLine());
                        System.out.print("Enter time (HH:mm): ");
                        time = LocalTime.parse(scanner.nextLine());
                    } catch (DateTimeParseException e) {
                        System.out.println("Invalid date or time format.");
                        continue;
                    }

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
                    LocalDate date;
                    LocalTime time;
                    try {
                        System.out.print("Enter date (yyyy-MM-dd): ");
                        date = LocalDate.parse(scanner.nextLine());
                        System.out.print("Enter time (HH:mm): ");
                        time = LocalTime.parse(scanner.nextLine());
                    } catch (DateTimeParseException e) {
                        System.out.println("Invalid date or time format.");
                        continue;
                    }

                    System.out.print("Enter patient name: ");
                    String patientName = scanner.nextLine();
                    patient = clinic.getPatientByName(patientName);
                    if (patient != null) {
                        clinic.bookAppointmentByphysiotherapist(physioName, patient, date, time);
                    } else {
                        System.out.println("Patient not found!");
                    }
                }
                case 3 -> {
                    System.out.print("Enter patient name: ");
                    String patientName = scanner.nextLine();
                    patient = clinic.getPatientByName(patientName);
                    if (patient != null) {
                        LocalDate date;
                        LocalTime time;
                        try {
                            System.out.print("Enter date (yyyy-MM-dd): ");
                            date = LocalDate.parse(scanner.nextLine());
                            System.out.print("Enter time (HH:mm): ");
                            time = LocalTime.parse(scanner.nextLine());
                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid date or time format.");
                            continue;
                        }
                        clinic.cancelAppointment(patient, date, time);
                    } else {
                        System.out.println("Patient not found!");
                    }
                }
                case 4 -> clinic.generateReport();
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }
}
