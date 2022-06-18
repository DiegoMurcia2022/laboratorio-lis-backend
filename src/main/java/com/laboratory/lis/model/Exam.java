package com.laboratory.lis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "exam")
public class Exam {
    @Id
    @Column(name = "exam_id")
    private String examId;

    @Column(name = "order_id")
    private String orderId;

    @Column(name = "exam_name")
    private String examName;

    @Column(name = "exam_result")
    private float examResult;

    public Exam() {
    }

    public Exam(String examId, String orderId, String examName, float examResult) {
        this.examId = examId;
        this.orderId = orderId;
        this.examName = examName;
        this.examResult = examResult;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public float getExamResult() {
        return examResult;
    }

    public void setExamResult(float examResult) {
        this.examResult = examResult;
    }
}
