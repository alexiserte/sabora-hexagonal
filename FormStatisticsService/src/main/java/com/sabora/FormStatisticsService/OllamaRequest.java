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
                    "prompt": {
                                     "id": 1,
                                     "name": "Encuesta de satisfacción y accesibilidad",
                                     "foodSpecialist": "12345672A",
                                     "creationDate": "2024-12-23",
                                     "questions": [
                                       {
                                         "type": "RANGE",
                                         "id": 101,
                                         "question": "¿Qué tan satisfecho estás con nuestro servicio?",
                                         "min": 1,
                                         "max": 10,
                                         "interval": 1
                                       },{
                                         "type": "RANGE",
                                         "id": 105,
                                         "question": "¿Consideras que la aplicación es accesible?",
                                         "min": 1,
                                         "max": 100,
                                         "interval": 5
                                       },
                                       {
                                         "type": "MULTIPLE_ANSWER",
                                         "id": 102,
                                         "question": "¿Qué servicios utilizaste?",
                                         "options": [
                                           "Entrega a domicilio",
                                           "Atención en tienda",
                                           "Asistencia telefónica"
                                         ]
                                       },
                                       {
                                         "type": "UNIQUE_ANSWER",
                                         "id": 103,
                                         "question": "¿Recomendarías nuestro servicio?",
                                         "options": [
                                           "Sí",
                                           "No"
                                         ]
                                       },
                                       {
                                         "type": "REDACTION",
                                         "id": 104,
                                         "question": "Por favor, escribe un comentario sobre tu experiencia."
                                       }
                                     ]
                                   }
                                   ",
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

