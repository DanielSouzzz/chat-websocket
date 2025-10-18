package org.aplication.chatwebsocket.config.websocketconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config){
        config.enableSimpleBroker("/topic", "/queue");
        config.setApplicationDestinationPrefixes("/app");
        config.setUserDestinationPrefix("/user"); // enviar mensagens privadas
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry){
        // endpoint pro cliente se conectar
        registry.addEndpoint("/chat-connect").setAllowedOriginPatterns("*").withSockJS();
    }
}