package com.codegnan.dao;

import java.util.ArrayList;
import java.util.List;

import com.codegnan.exceptions.PatientNotFoundException;
import com.codegnan.model.Patient;

public class PatientDaoImpl implements PatientDao {

    private List<Patient> patientList = new ArrayList<>();

    @Override
    public void save(Patient patient) {
        patientList.add(patient);
    }

    @Override
    public List<Patient> findAll() {
        return patientList;
    }

    @Override
    public Patient findById(int id) throws PatientNotFoundException {
        for (Patient p : patientList) {
            if (p.getId() == id) {
                return p;
            }
        }
        throw new PatientNotFoundException("Patient with ID " + id + " not found.");
    }

    @Override
    public Patient update(Patient patient) throws PatientNotFoundException {
        for (int i = 0; i < patientList.size(); i++) {
            if (patientList.get(i).getId() == patient.getId()) {
                patientList.set(i, patient);
                return patient;
            }
        }
        throw new PatientNotFoundException(
                "Patient with ID " + patient.getId() + " not found. Cannot update.");
    }

    @Override
    public void deleteById(int id) throws PatientNotFoundException {
        for (int i = 0; i < patientList.size(); i++) {
            if (patientList.get(i).getId() == id) {
                patientList.remove(i);
                return;
            }
        }
        throw new PatientNotFoundException(
                "Patient with ID " + id + " not found. Cannot delete.");
    }
}
