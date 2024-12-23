package com.sabora.server.Clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "file-service", url = "http://localhost:8081")
public interface FileServiceClient {

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadFile(@RequestPart("file") MultipartFile file);


    @DeleteMapping("/delete")
    ResponseEntity<String> deleteFile(@RequestParam("fileName") String fileName);
}