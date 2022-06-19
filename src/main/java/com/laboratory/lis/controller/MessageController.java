package com.laboratory.lis.controller;

import com.laboratory.lis.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/laboratory-lis")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @PostMapping
    public ResponseEntity<String> manageMessage(@RequestParam(value = "message") String message) {
        try {
            messageService.manageMessage(message);
            return ResponseEntity.status(HttpStatus.OK).body("Message received");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
