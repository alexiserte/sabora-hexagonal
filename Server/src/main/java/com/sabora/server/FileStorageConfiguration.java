package com.sabora.server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FileStorageConfiguration {

    @Value("${file.upload-dir.images}")
    private String imageUploadPath;

    @Value("${file.upload-dir.audios}")
    private String audioUploadPath;

    public String getImageUploadPath() {
        return imageUploadPath;
    }

    public void setImageUploadPath(String imageUploadPath) {
        this.imageUploadPath = imageUploadPath;
    }
}
