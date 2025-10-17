package com.codegnan.controller;
import java.util.List;
import com.codegnan.exceptions.PatientNotFoundException;
import com.codegnan.model.Patient;
import com.codegnan.service.PatientService;
import com.codegnan.service.PatientServiceImpl;

public class HospitalController {

    public static void main(String[] args) {

        PatientService service = new PatientServiceImpl();

        service.addPatient(new Patient(101, "Ravi Kumar", 32, "Fever"));
        service.addPatient(new Patient(102, "Lalitha Devi", 28, "Cough"));
        service.addPatient(new Patient(103, "Sandeep", 45, "Back Pain"));
        service.addPatient(new Patient(104, "Divya", 40, "Headache"));
        service.addPatient(new Patient(105, "Kiran", 25, "Cold"));

        System.out.println("All Patients:");
        List<Patient> patients = service.getAllPatients();
        for (Patient p : patients) {
            System.out.println(p);
        }

        System.out.println("\nGet Patient By ID: 103");
        try {
            Patient patient = service.getPatient(103);
            System.out.println(patient);
        } catch (PatientNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("\nUpdate Patient with ID 104");
        try {
            Patient updated = service.updatePatient(new Patient(104, "Divya Reddy", 41, "Migraine"));
            System.out.println(updated);
        } catch (PatientNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("\nDelete Patient with ID 101");
        try {
            service.deletePatient(101);
            System.out.println("Patient deleted successfully.");
        } catch (PatientNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("\nAfter all operations, final patient list:");
        List<Patient> remainingPatients = service.getAllPatients();
        for (Patient p : remainingPatients) {
            System.out.println(p);
        }
    }
}
