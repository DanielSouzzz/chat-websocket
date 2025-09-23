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
        // prefixo para onde o servidor publica mensagens
        config.enableSimpleBroker("/chat");
        // prefixo para onde o cliente envia mensagens
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry){
        // endpoint pro cliente se conectar
        registry.addEndpoint("/chat-connect").setAllowedOriginPatterns("*").withSockJS();
    }
}
