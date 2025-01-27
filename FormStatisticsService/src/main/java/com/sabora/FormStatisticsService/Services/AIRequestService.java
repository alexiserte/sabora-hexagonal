package com.sabora.FormStatisticsService.Services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class AIRequestService {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static String getAIResponse(String promptData){
        try {
            HttpClient client = HttpClient.newHttpClient();
            String requestBody = String.format("""
                {
                    "model": "sabora-ai-model",
                    "prompt": "%s",
                    "stream": false
                }
                """, promptData);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:11434/api/generate"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();

            JsonNode node = mapper.readTree(responseBody);
            return node.get("response").asText();

        } catch (Exception e) {
            System.err.println("Error realizando la petición:");
            e.printStackTrace();
        }

        return "No se pudo obtener información añadida, por favor pruebe mas tarde";
    }
}
