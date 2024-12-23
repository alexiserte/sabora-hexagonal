package com.sabora.server.Clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "file-service", url = "http://localhost:8081")
public interface FileServiceClient {

    @PostMapping("/upload")
    ResponseEntity<String> uploadFile(@RequestPart("file") MultipartFile file);

    @DeleteMapping("/delete")
    ResponseEntity<String> deleteFile(@RequestParam("fileName") String fileName);
}