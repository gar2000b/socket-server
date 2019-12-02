package com.onlineinteract.socketserver;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SocketServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocketServerApplication.class, args);
	}

	@PostConstruct
	public void init() {
		System.out.println("Initialing Socket Server");
	}
}
