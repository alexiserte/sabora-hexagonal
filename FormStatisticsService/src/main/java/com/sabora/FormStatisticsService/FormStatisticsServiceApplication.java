package com.sabora.FormStatisticsService;

import com.sabora.FormStatisticsService.Services.AIRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FormStatisticsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FormStatisticsServiceApplication.class, args);
		System.out.println(AIRequestService.getAIResponse("{id: 1, name: Encuesta de satisfacción y accesibilidad, foodSpecialist: 12345672A, creationDate: 2024-12-23, questions: [{type: RANGE, id: 101, question: ¿Qué tan satisfecho estás con nuestro servicio?, min: 1, max: 10, interval: 1}, {type: RANGE, id: 105, question: ¿Consideras que la aplicación es accesible?, min: 1, max: 100, interval: 5}, {type: MULTIPLE_ANSWER, id: 102, question: ¿Qué servicios utilizaste?, options: [Entrega a domicilio, Atención en tienda, Asistencia telefónica]}, {type: UNIQUE_ANSWER, id: 103, question: ¿Recomendarías nuestro servicio?, options: [Sí, No]}, {type: REDACTION, id: 104, question: Por favor, escribe un comentario sobre tu experiencia.}]}"));
	}

}
