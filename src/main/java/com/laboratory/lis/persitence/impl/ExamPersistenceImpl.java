package com.laboratory.lis.persitence.impl;

import com.laboratory.lis.model.Exam;
import com.laboratory.lis.persitence.ExamPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class ExamPersistenceImpl implements ExamPersistence {
    @Autowired
    private ExamPersistence examPersistence;

    @PersistenceContext
    private EntityManager entityManager;

    public ExamPersistenceImpl() {
    }

    @Override
    public void save(Exam exam) {
        examPersistence.save(exam);
    }
}
