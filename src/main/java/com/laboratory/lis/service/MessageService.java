package com.laboratory.lis.service;

import org.springframework.web.multipart.MultipartFile;

public interface MessageService {
    void manageMessage(String message);
    void manageFile(MultipartFile file);
}
