package com.sabora.server.Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader {
    public static String leerArchivo(String rutaArchivo) {
        String contenido = "";
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(rutaArchivo));
            contenido = new String(bytes);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return contenido;
    }
}
