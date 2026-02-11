package com.sia.chat.adapter.in.ws.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sia.chat.common.TimeProvider;
import com.sia.chat.adapter.in.ws.dto.PingRequest;
import com.sia.chat.adapter.in.ws.dto.PongResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PingController {

	private final TimeProvider timeProvider;

	@MessageMapping("/ping")      // client 요청 url /app/ping
	@SendTo("/topic/pong")        // clients 구독 url  /topic/pong
	public PongResponse ping(@Valid @RequestBody PingRequest message) {
		String text = message.text();
		return new PongResponse(text, timeProvider.nowIso());
	}
}
