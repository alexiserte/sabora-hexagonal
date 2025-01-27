package com.sabora.FormStatisticsService;

import com.sabora.FormStatisticsService.Services.AIRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FormStatisticsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FormStatisticsServiceApplication.class, args);
		System.out.println(AIRequestService.getAIResponse("{\n" +
				"  \"id\": 1,\n" +
				"  \"name\": \"Encuesta de satisfacción y accesibilidad\",\n" +
				"  \"foodSpecialist\": \"12345672A\",\n" +
				"  \"creationDate\": \"2024-12-23\",\n" +
				"  \"questions\": [\n" +
				"    {\n" +
				"      \"type\": \"RANGE\",\n" +
				"      \"id\": 101,\n" +
				"      \"question\": \"¿Qué tan satisfecho estás con nuestro servicio?\",\n" +
				"      \"min\": 1,\n" +
				"      \"max\": 10,\n" +
				"      \"interval\": 1\n" +
				"    },{\n" +
				"      \"type\": \"RANGE\",\n" +
				"      \"id\": 105,\n" +
				"      \"question\": \"¿Consideras que la aplicación es accesible?\",\n" +
				"      \"min\": 1,\n" +
				"      \"max\": 100,\n" +
				"      \"interval\": 5\n" +
				"    },\n" +
				"    {\n" +
				"      \"type\": \"MULTIPLE_ANSWER\",\n" +
				"      \"id\": 102,\n" +
				"      \"question\": \"¿Qué servicios utilizaste?\",\n" +
				"      \"options\": [\n" +
				"        \"Entrega a domicilio\",\n" +
				"        \"Atención en tienda\",\n" +
				"        \"Asistencia telefónica\"\n" +
				"      ]\n" +
				"    },\n" +
				"    {\n" +
				"      \"type\": \"UNIQUE_ANSWER\",\n" +
				"      \"id\": 103,\n" +
				"      \"question\": \"¿Recomendarías nuestro servicio?\",\n" +
				"      \"options\": [\n" +
				"        \"Sí\",\n" +
				"        \"No\"\n" +
				"      ]\n" +
				"    },\n" +
				"    {\n" +
				"      \"type\": \"REDACTION\",\n" +
				"      \"id\": 104,\n" +
				"      \"question\": \"Por favor, escribe un comentario sobre tu experiencia.\"\n" +
				"    }\n" +
				"  ]\n" +
				"}\n" +
				"'"));
	}

}
