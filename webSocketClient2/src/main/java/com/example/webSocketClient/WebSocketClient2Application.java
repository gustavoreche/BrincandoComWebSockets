package com.example.webSocketClient;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.converter.StringMessageConverter;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import com.example.webSocketClient.client.MyWebSocketClient;

@SpringBootApplication
public class WebSocketClient2Application implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(WebSocketClient2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		WebSocketClient webSocketClient = new StandardWebSocketClient();
        WebSocketStompClient stompClient = new WebSocketStompClient(webSocketClient);
        stompClient.setMessageConverter(new StringMessageConverter());
        stompClient.setTaskScheduler(new ConcurrentTaskScheduler());

        String url = "ws://127.0.0.1:8080/enviaCliente2";
        StompSessionHandler sessionHandler = new MyWebSocketClient();
        StompSession session = stompClient.connect(url, sessionHandler).get();
        
        System.out.println("Para sair digite 0");
        String digita = "";
        while(!digita.equals("0")) {
        	Scanner scanner = new Scanner(System.in);
        	digita = scanner.nextLine();
        	session.send("/app/enviaCliente2", "Cliente 2: " + digita);
        }

	}

}
