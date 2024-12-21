package com.sabora.fileManagementService.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileManagementService {
    public String saveFile(MultipartFile file);
    public void deleteFile(String fileName);

}
