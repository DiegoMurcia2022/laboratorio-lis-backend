package com.laboratory.lis.service.impl;

import com.laboratory.lis.model.Exam;
import com.laboratory.lis.model.Patient;
import com.laboratory.lis.model.PatientOrder;
import com.laboratory.lis.persitence.ExamPersistence;
import com.laboratory.lis.persitence.PatientOrderPersistence;
import com.laboratory.lis.persitence.PatientPersistence;
import com.laboratory.lis.service.MessageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired PatientPersistence patientPersistence;
    @Autowired PatientOrderPersistence patientOrderPersistence;
    @Autowired ExamPersistence examPersistence;
    
    private List<String> section;
    private String[] messageArray;
    private String patientId, orderId;

    private final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public MessageServiceImpl() {
        section = new ArrayList<>();
    }

    @Override
    public void manageMessage(String message) {
        message = message.replaceAll("\\[CR]", ",");
        messageArray = message.split(",");

        for (String i : messageArray) {
            section = Arrays.asList(i.replaceAll("\\|+", ",").split(","));
            section.removeAll(Arrays.asList("", null));

            if (!section.get(0).equals("H") || !section.get(0).equals("L")) manageInformation(section);
        }
    }

    @Override
    public void manageFile(MultipartFile file) {
        try {
            String data;
            InputStream inputStream = file.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            while ((data = bufferedReader.readLine()) != null) {
                manageMessage(data);
            }
        } catch (IOException e) {
            throw new RuntimeException("Fail to parse TXT file: " + e.getMessage());
        }
    }

    private void manageInformation(List<String> data) {
        switch (data.get(0)) {
            case "P":
                patientId = data.get(2);
                patientPersistence.save(new Patient(patientId, data.get(4), data.get(3), data.get(5), LocalDate.parse(data.get(6))));
                break;
            case "O":
                orderId = data.get(2);
                patientOrderPersistence.save(new PatientOrder(orderId, patientId, LocalDateTime.parse(data.get(3), FORMATTER), data.get(4)));
                break;
            case "R":
                examPersistence.save(new Exam(data.get(2), orderId, data.get(3), Float.parseFloat(data.get(4))));
                break;
        }
    }
}
