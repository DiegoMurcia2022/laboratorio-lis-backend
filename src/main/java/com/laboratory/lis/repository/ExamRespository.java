package com.laboratory.lis.repository;

import com.laboratory.lis.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRespository extends JpaRepository<Exam, String> {

}
