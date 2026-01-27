package com.sia.chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// STOMP endpoint: ws://localhost:8080/ws -> 환경 분리 필요
		registry.addEndpoint("/ws")
			.setAllowedOriginPatterns("*") // CORS 와일드 카드 (로컬/테스트용)
			.withSockJS();
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		// 클라이언트 -> 서버로 보낼 때 prefix
		registry.setApplicationDestinationPrefixes("/app");

		// 서버 -> 클라이언트 브로커 prefix (메시지 브로드캐스트)
		registry.enableSimpleBroker("/topic");
	}
}