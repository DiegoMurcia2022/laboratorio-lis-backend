package com.laboratory.lis.persitence.impl;

import com.laboratory.lis.model.Patient;
import com.laboratory.lis.persitence.PatientPersistence;
import com.laboratory.lis.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Service
public class PatientPersistenceImlp implements PatientPersistence {
    @Autowired
    PatientRepository patientRepository;

    @PersistenceContext
    EntityManager entityManager;

    public PatientPersistenceImlp() {
    }

    @Override
    public void save(Patient patient) {
        patientRepository.save(patient);
    }
}
