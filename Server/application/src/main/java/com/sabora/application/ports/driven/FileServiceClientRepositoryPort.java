package com.sabora.application.ports.driven;

import org.springframework.web.multipart.MultipartFile;

public interface FileServiceClientRepositoryPort {
    String uploadFile(MultipartFile file);
    String deleteFile(String fileName);
}
