package com.sabora.application.services;

import com.sabora.application.ports.driven.FileServiceClientRepositoryPort;
import com.sabora.application.ports.driving.FileServiceClientServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@AllArgsConstructor
public class FileServiceClientServiceImplementation implements FileServiceClientServices {

    private FileServiceClientRepositoryPort fileServiceClientRepositoryPort;


    @Override
    public String uploadFile(MultipartFile file) {
        return fileServiceClientRepositoryPort.uploadFile(file);
    }

    @Override
    public String deleteFile(String fileName) {
        return fileServiceClientRepositoryPort.deleteFile(fileName);
    }
}
