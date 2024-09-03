package org.example.java_hopital.repository;

import org.example.java_hopital.entity.Patient;

public class PatientRepository extends BaseRepository<Patient> {
    public PatientRepository() {
        super(Patient.class);
    }
}
