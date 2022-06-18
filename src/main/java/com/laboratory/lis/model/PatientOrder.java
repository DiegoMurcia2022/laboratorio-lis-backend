package com.laboratory.lis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "patient_order")
public class PatientOrder {
    @Id
    @Column(name = "order_id")
    private String orderId;

    @Column(name = "patient_id")
    private String patientId;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @Column(name = "order_type")
    private String orderType;

    public PatientOrder() {
    }

    public PatientOrder(String orderId, String patientId, LocalDateTime orderDate, String orderType) {
        this.orderId = orderId;
        this.patientId = patientId;
        this.orderDate = orderDate;
        this.orderType = orderType;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
}
