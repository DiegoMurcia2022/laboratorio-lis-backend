package com.laboratory.lis.service.impl;

import com.laboratory.lis.model.Patient;
import com.laboratory.lis.persitence.PatientPersistence;
import com.laboratory.lis.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    PatientPersistence patientPersistence;

    public PatientServiceImpl() {
    }

    @Override
    public void save(Patient patient) {
        patientPersistence.save(patient);
    }
}
