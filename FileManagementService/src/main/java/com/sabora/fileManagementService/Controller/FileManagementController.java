package com.sabora.fileManagementService.Controller;

import com.sabora.fileManagementService.Exception.EmptyFileException;
import com.sabora.fileManagementService.Service.FileManagementService;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileManagementController {

    FileManagementService fileManagementService;

    public FileManagementController(FileManagementService fileManagementService) {
        this.fileManagementService = fileManagementService;
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam(name = "file") MultipartFile file) {
        if(file.isEmpty()) {
            return new ResponseEntity<>(new EmptyFileException("The file is empty!"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else{
            String fileURL = fileManagementService.saveFile(file);
            return new ResponseEntity<>(fileURL, HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteFile(@RequestParam(name = "fileName") String fileName) {
        fileManagementService.deleteFile(fileName);
        return new ResponseEntity<>("File deleted successfully", HttpStatus.OK);
    }
}
