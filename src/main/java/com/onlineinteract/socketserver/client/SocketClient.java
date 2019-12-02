package com.onlineinteract.socketserver.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 8081);
			PrintStream printStream = new PrintStream(socket.getOutputStream());
			BufferedReader readerIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			printStream.println("Hello Cyberdyne");
			System.out.println(readerIn.readLine());
			socket.close();
			readerIn.close();
			printStream.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
