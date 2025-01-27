package com.sabora.FormStatisticsService;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class OllamaRequest {

    public static void main(String[] args) {
        try {
            // Crear cliente HTTP
            HttpClient client = HttpClient.newHttpClient();

            // Crear JSON con los datos de la solicitud
            String requestBody = """
                {
                    "model": "sabora-ai-model",
                    "prompt": "tell me a joke",
                    "stream": false
                }
                """;

            // Crear solicitud HTTP POST
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:11434/api/generate"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            // Enviar solicitud y obtener respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Imprimir la respuesta
            System.out.println("Respuesta del servidor:");
            System.out.println(response.body());

            //Obtener el campo response del JSON empleando objectmapper
            String responseString = response.body();

            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(responseString);
            String joke = node.get("response").asText();
            System.out.println("Joke: " + joke);

        } catch (Exception e) {
            System.err.println("Error realizando la petición:");
            e.printStackTrace();
        }
    }
}

