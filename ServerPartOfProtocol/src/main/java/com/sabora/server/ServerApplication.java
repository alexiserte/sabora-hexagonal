package com.sabora.server;

import com.sabora.server.Socket.RepSocket;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
		RepSocket socket = new RepSocket(8080);
		System.out.println("Hello World!");
		socket.answerMessage();
	}

}
