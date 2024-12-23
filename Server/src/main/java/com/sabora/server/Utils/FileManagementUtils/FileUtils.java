package com.sabora.server.Utils.FileManagementUtils;

import org.springframework.http.MediaType;

public class FileUtils {

    private static String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        return dotIndex == -1 ? "" : fileName.substring(dotIndex + 1).toLowerCase();
    }

    public static MediaType getMediaType(String fileName) {
        String extension = getFileExtension(fileName);
        switch (extension) {
            case "jpg":
            case "jpeg":
                return MediaType.IMAGE_JPEG;
            case "png":
                return MediaType.IMAGE_PNG;
            case "gif":
                return MediaType.IMAGE_GIF;
            case "pdf":
                return MediaType.APPLICATION_PDF;
            case "mp4":
                return MediaType.valueOf("video/mp4");
            case "mp3":
                return MediaType.valueOf("audio/mp3");
            case "wav":
                return MediaType.valueOf("audio/wav"); // Soporte para archivos WAV
            case "txt":
                return MediaType.TEXT_PLAIN;
            case "html":
                return MediaType.TEXT_HTML;
            default:
                return MediaType.APPLICATION_OCTET_STREAM; // Para archivos binarios genéricos
        }
    }
}
