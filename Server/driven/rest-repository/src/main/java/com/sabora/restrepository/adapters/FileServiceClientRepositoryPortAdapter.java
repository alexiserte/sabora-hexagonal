package com.sabora.restrepository.adapters;

import com.sabora.application.ports.driven.FileServiceClientRepositoryPort;
import com.sabora.restrepository.clients.FileServiceClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
@AllArgsConstructor
public class FileServiceClientRepositoryPortAdapter implements FileServiceClientRepositoryPort {
    private final FileServiceClient fileServiceClient;

    @Override
    public String uploadFile(MultipartFile file) {
        return fileServiceClient.uploadFile(file).getBody();
    }

    @Override
    public String deleteFile(String fileName) {
        return fileServiceClient.deleteFile(fileName).getBody();
    }
}
