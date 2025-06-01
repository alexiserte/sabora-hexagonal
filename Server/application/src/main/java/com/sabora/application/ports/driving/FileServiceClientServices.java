package com.sabora.application.ports.driving;

import org.springframework.web.multipart.MultipartFile;

public interface FileServiceClientServices {
    String uploadFile(MultipartFile file);
    String deleteFile(String fileName);
}
