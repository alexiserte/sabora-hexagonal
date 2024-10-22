package com.sabora.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.sabora.server.Utils.FileReader.leerArchivo;

@RestController
@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {SpringApplication.run(ServerApplication.class, args);}

	@GetMapping("/")
	public String mainPage(){
		String webPage = leerArchivo("src/main/java/com/sabora/server/HTMLPages/bienvenida.html");
		return webPage;
	}

	@GetMapping("/test-vr")
	public String testVRButton(){
			return "Hola! Bienvenido a Sabora!";
	}

	@GetMapping("/current-connections")
	public String currentConnections(){
		return CurrentConnections.currentVRGlassesConnections.toString();
	}
}
