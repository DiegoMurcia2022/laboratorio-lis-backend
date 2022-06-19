package com.laboratory.lis.persitence.impl;

import com.laboratory.lis.model.PatientOrder;
import com.laboratory.lis.persitence.PatientOrderPersistence;
import com.laboratory.lis.repository.PatientOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class PatientOrderPersistenceImpl implements PatientOrderPersistence {
    @Autowired private PatientOrderRepository patientOrderRepository;

    @PersistenceContext private EntityManager entityManager;

    public PatientOrderPersistenceImpl() {
    }

    @Override
    public void save(PatientOrder patientOrder) {
        patientOrderRepository.save(patientOrder);
    }
}
