package com.sabora.server.Controllers;

import com.sabora.server.Clients.FileServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileManagementController {

    private FileServiceClient fileServiceClient;

    public FileManagementController(FileServiceClient fileServiceClient) {
        this.fileServiceClient = fileServiceClient;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam(name = "file") MultipartFile file) {
        return fileServiceClient.uploadFile(file);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteFile(@RequestParam(name = "fileName") String fileName) {
        return fileServiceClient.deleteFile(fileName);
    }

    @GetMapping("/resources/{fileName}")
    public ResponseEntity<MultipartFile> downloadFile(@PathVariable("fileName") String fileName) {
        return fileServiceClient.downloadFile(fileName);
    }
}
