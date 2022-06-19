package com.laboratory.lis.service.impl;

import com.google.gson.Gson;
import com.laboratory.lis.model.Message;
import com.laboratory.lis.model.Patient;
import com.laboratory.lis.persitence.ExamPersistence;
import com.laboratory.lis.persitence.PatientOrderPersistence;
import com.laboratory.lis.persitence.PatientPersistence;
import com.laboratory.lis.service.MessageService;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired private PatientPersistence patientPersistence;
    @Autowired private PatientOrderPersistence patientOrderPersistence;
    @Autowired private ExamPersistence examPersistence;
    private List<String> section;
    private String[] messageArray;
    private String patientId, patientName, patientSurname, patientGender, orderId, orderType, examId, examName;
    private LocalDate patientBirthDate;
    private LocalDateTime orderDate;
    private float examResult;

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

    private void manageInformation(List<String> data) {
        switch (data.get(0)) {
            case "P":
                patientId = data.get(2);
                patientSurname = data.get(3);
                patientName = data.get(4);
                patientGender = data.get(5);
                patientBirthDate = LocalDate.parse(data.get(6));
                patientPersistence.save(new Patient());
                break;
            case "O":
                break;
            case "R":
                break;
        }
    }
}
