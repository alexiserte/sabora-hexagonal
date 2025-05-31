package com.sabora.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {
		"com.sabora.database.entities"
})
@EnableJpaRepositories(basePackages = {
		"com.sabora.database.repositories"
})
@EnableFeignClients(basePackages = {
		"com.sabora.restrepository.clients"
})
public class ServerApplication {

	public static void main(String[] args) {SpringApplication.run(ServerApplication.class, args);}

}
