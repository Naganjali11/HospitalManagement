package com.codegnan.dao;

import java.util.List;

import com.codegnan.exceptions.PatientNotFoundException;
import com.codegnan.model.Patient;

public interface PatientDao {
    void save(Patient patient);

    List<Patient> findAll();

    Patient findById(int id) throws PatientNotFoundException;

    Patient update(Patient patient) throws PatientNotFoundException;

    void deleteById(int id) throws PatientNotFoundException;
}

