package com.sabora.server.Controllers;

import com.sabora.server.Clients.FileServiceClient;
import com.sabora.server.Utils.FileManagementUtils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
public class FileManagementController {

    @Autowired
    private FileServiceClient fileServiceClient;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam(name = "file") MultipartFile file) {
        return fileServiceClient.uploadFile(file);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteFile(@RequestParam(name = "fileName") String fileName) {
        return fileServiceClient.deleteFile(fileName);
    }

    @GetMapping("/resources/{fileName}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable("fileName") String fileName) {
        try {
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8081/resources/" + fileName))
                    .GET()
                    .build();

            HttpResponse<byte[]> response = httpClient.send(request, HttpResponse.BodyHandlers.ofByteArray());

            MediaType fileMediaType = FileUtils.getMediaType(fileName);

            return ResponseEntity.ok().contentType(fileMediaType).body(response.body());

        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
