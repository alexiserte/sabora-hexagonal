package com.sabora.api.adapters;

import com.sabora.application.FileManagementUtils.FileUtils;
import com.sabora.application.ports.driving.FileServiceClientServices;
import org.openapitools.api.FileApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
public class FileManagementController implements FileApi {

    @Autowired
    private FileServiceClientServices fileServiceClient;

    @Override
    public ResponseEntity<String> uploadFile(MultipartFile file) {
        return ResponseEntity.ok(fileServiceClient.uploadFile(file));
    }


    @Override
    public ResponseEntity<String> deleteFile(String fileName) {
        return ResponseEntity.ok(fileServiceClient.deleteFile(fileName));
    }

    @Override
    public ResponseEntity<Resource> downloadFile(String fileName) {
        try {
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8081/resources/" + fileName))
                    .GET()
                    .build();

            HttpResponse<byte[]> response = httpClient.send(request, HttpResponse.BodyHandlers.ofByteArray());

            ByteArrayResource resource = new ByteArrayResource(response.body());

            MediaType fileMediaType = FileUtils.getMediaType(fileName);

            return ResponseEntity.ok()
                    .contentType(fileMediaType)
                    .body(resource);

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
