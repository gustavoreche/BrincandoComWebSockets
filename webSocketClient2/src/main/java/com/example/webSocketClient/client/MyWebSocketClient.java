package com.example.webSocketClient.client;

import java.lang.reflect.Type;

import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

public class MyWebSocketClient extends StompSessionHandlerAdapter {

	@Override
	public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
		session.subscribe("/topic/recebeCliente1", this);
		session.send("/app/enviaCliente2", "Cliente 2 CONECTADO");
	}

	@Override
	public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload,
			Throwable exception) {
		exception.printStackTrace();
	}
	
    @Override
    public Type getPayloadType(StompHeaders headers) {
        return String.class;
    }

	@Override
	public void handleFrame(StompHeaders headers, Object payload) {
		System.err.println(payload);
	}

}
