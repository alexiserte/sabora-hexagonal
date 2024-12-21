package com.sabora.fileManagementService.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Service
public class FileManagementImpl implements FileManagementService {

    @Value("${file.upload-dir}")
    private String fileUploadPath;

    @Override
    public String saveFile(MultipartFile file) {
        try {
            File directory = new File(fileUploadPath);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            File destFile = new File(directory, file.getOriginalFilename());
            file.transferTo(destFile);

            String fileUrl = "/resources/" + file.getOriginalFilename();
            return fileUrl;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteFile(String fileName) {
        File file = new File(fileUploadPath, fileName);
        if (file.exists()) {
            if (!file.delete()) {
                throw new RuntimeException("No se pudo eliminar el archivo: " + fileName);
            }
        } else {
            throw new RuntimeException("Archivo no encontrado: " + fileName);
        }
    }

}
