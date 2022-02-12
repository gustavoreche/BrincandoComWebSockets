package com.example.demo.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

	@MessageMapping("/enviaCliente1")
	@SendTo("/topic/recebeCliente1")
	public String enviaMensagem(String message) {
		System.out.println("Servidor. Mensagem: " + message);
		return message;
	}
	
	@MessageMapping("/enviaCliente2")
	@SendTo("/topic/recebeCliente2")
	public String broadcastNews(String message) {
		System.out.println("Servidor. Mensagem: " + message);
		return message;
	}

}
