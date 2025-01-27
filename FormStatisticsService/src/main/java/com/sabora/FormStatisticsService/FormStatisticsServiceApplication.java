package com.sabora.FormStatisticsService;

import com.sabora.FormStatisticsService.Services.AIRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FormStatisticsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FormStatisticsServiceApplication.class, args);
		AIRequestService.getAIResponse("Hola");
	}

}
