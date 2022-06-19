package com.laboratory.lis.repository;

import com.laboratory.lis.model.PatientOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientOrderRepository extends JpaRepository<PatientOrder, String> {

}
