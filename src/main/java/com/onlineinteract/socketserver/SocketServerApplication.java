package com.onlineinteract.socketserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SocketServerApplication {

	private int port = 8081;
	private ServerSocket socket;
	private boolean runningFlag = true;
	private Socket incoming;
	private BufferedReader readerIn;
	private PrintStream printOut;
	private String message;

	public static void main(String[] args) {
		SpringApplication.run(SocketServerApplication.class, args);
	}

	@PostConstruct
	public void init() {
		System.out.println("Initialing Socket Server on port: " + port);
		try {
			socket = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}

		while (runningFlag) {
			try {
				System.out.println("Setting up incoming socket connection, reader and writer");
				incoming = socket.accept();
				readerIn = new BufferedReader(new InputStreamReader(incoming.getInputStream()));
				printOut = new PrintStream(incoming.getOutputStream());
				System.out.println("Setting up connection, reader and writer complete");
				System.out.println("About to read in a message");
				message = readerIn.readLine();
				System.out.println("Message in: " + message);
				printOut.println("Server Received message: " + message);
				incoming.close();
				readerIn.close();
				printOut.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
