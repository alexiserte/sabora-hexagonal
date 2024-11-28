package com.sabora.server;

import com.sabora.server.Models.User;
import com.sabora.server.Repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.sabora.server.Utils.FileReader.leerArchivo;

@RestController
@SpringBootApplication
@Service
public class ServerApplication {


	public static FoodRepository foodRepository;

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
		System.out.println(foodRepository.findAll());
	}

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
