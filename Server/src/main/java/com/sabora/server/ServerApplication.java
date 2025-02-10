package com.sabora.server;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.sabora.server.Utils.FileReader.leerArchivo;

@RestController
@SpringBootApplication
@EnableFeignClients
public class ServerApplication {

	public ApplicationContext context;

	public static void main(String[] args) {
		var context = SpringApplication.run(ServerApplication.class, args);

	}


	@GetMapping("/")
	public String mainPage(){
		String webPage = leerArchivo("src/main/java/com/sabora/server/HTMLPages/bienvenida.html");
		return webPage;
	}

}
