package com.laboratory.lis.persitence.impl;

import com.laboratory.lis.model.Patient;
import com.laboratory.lis.persitence.PatientPersistence;
import com.laboratory.lis.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class PatientPersistenceImlp implements PatientPersistence {
    @Autowired private PatientRepository patientRepository;

    @PersistenceContext private EntityManager entityManager;

    public PatientPersistenceImlp() {
    }

    @Override
    public void save(Patient patient) {
        patientRepository.save(patient);
    }
}
