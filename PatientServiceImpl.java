package com.codegnan.service;

import java.util.ArrayList;
import java.util.List;
import com.codegnan.model.Patient;
import com.codegnan.exceptions.PatientNotFoundException;

public class PatientServiceImpl implements PatientService {
    private List<Patient> patients = new ArrayList<>();

    @Override
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patients;
    }

    @Override
    public Patient getPatient(int id) throws PatientNotFoundException {
        for (Patient p : patients) {
            if (p.getId() == id) {
                return p;
            }
        }
        throw new PatientNotFoundException("Patient not found with ID: " + id);
    }

    @Override
    public Patient updatePatient(Patient updatedPatient) throws PatientNotFoundException {
        for (int i = 0; i < patients.size(); i++) {
            Patient p = patients.get(i);
            if (p.getId() == updatedPatient.getId()) {
                patients.set(i, updatedPatient);
                return updatedPatient;
            }
        }
        throw new PatientNotFoundException("Cannot update. Patient not found with ID: " + updatedPatient.getId());
    }

    @Override
    public void deletePatient(int id) throws PatientNotFoundException {
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getId() == id) {
                patients.remove(i);
                return;
            }
        }
        throw new PatientNotFoundException("Cannot delete. Patient not found with ID: " + id);
    }
}
