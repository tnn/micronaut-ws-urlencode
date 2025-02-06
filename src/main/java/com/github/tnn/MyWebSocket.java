package com.github.tnn;

import io.micronaut.http.HttpRequest;
import io.micronaut.websocket.CloseReason;
import io.micronaut.websocket.WebSocketPongMessage;
import io.micronaut.websocket.WebSocketSession;
import io.micronaut.websocket.annotation.OnClose;
import io.micronaut.websocket.annotation.OnError;
import io.micronaut.websocket.annotation.OnMessage;
import io.micronaut.websocket.annotation.OnOpen;
import io.micronaut.websocket.annotation.ServerWebSocket;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ServerWebSocket(value = "/{identity}", subprotocols = "test1.6,test2.0")
@Singleton
public class MyWebSocket {
    private static final Logger LOG = LoggerFactory.getLogger(MyWebSocket.class);

    public MyWebSocket() {
        LOG.info("Created websocket handler.");
    }

    @OnOpen
    public void onOpen(String identity, HttpRequest<?> httpRequest, WebSocketSession session) {
        LOG.info("Websocket connection opened for identity {}: {}, {}", identity, session.getId(), httpRequest);
    }

    @OnMessage
    public void onMessage(String identity, String message, WebSocketSession session) {
        LOG.info("Websocket message received: {}", session.getId());
    }

    @OnMessage
    public void onPongMessage(String identity, WebSocketPongMessage pong, WebSocketSession session) {
        LOG.info("Websocket pong received: {}", session.getId());
    }

    @OnClose
    public void onClose(String identity, CloseReason reason, WebSocketSession session) {
        LOG.info("closed session {}, reason: {}", session.getId(), reason);
    }

    @OnError
    public void onError(String identity, Throwable ex, WebSocketSession session) {
        LOG.info("Error received on {}", session.getId(), ex);
    }
}
