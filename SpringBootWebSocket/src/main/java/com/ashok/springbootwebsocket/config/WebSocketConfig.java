package com.ashok.springbootwebsocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * Config which extends an Abstract class that expects us to config necessary details for the web sockets
 * @author Ashok Sen Gurudayal
 *
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer{
	
	//This is the path where web sockets are going to be created
	@Override
	public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
		//Socket end point
		stompEndpointRegistry.addEndpoint("/websocket-example")
		.withSockJS();//enable socket with sockjs library
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.enableSimpleBroker("/topic/user"); //This is where we push the messages
		registry.setApplicationDestinationPrefixes("/app");
	}
	
	
}
