package com.codegnan.service;

import java.util.List;

import com.codegnan.exceptions.PatientNotFoundException;
import com.codegnan.model.Patient;

public interface PatientService {
    void addPatient(Patient patient);

    List<Patient> getAllPatients();

    Patient getPatient(int id) throws PatientNotFoundException;

    Patient updatePatient(Patient patient) throws PatientNotFoundException;

    void deletePatient(int id) throws PatientNotFoundException;
}

