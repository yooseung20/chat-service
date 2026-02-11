package com.sia.chat.adapter.in.ws.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.sia.chat.adapter.in.ws.dto.ChatSendRequest;
import com.sia.chat.adapter.in.ws.dto.ChatSendResponse;
import com.sia.chat.common.TimeProvider;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ChatWsController {

	public final SimpMessagingTemplate template;
	public final TimeProvider timeProvider;

	@MessageMapping("/chat.send")
	public void send(ChatSendRequest req) {
		var res = new ChatSendResponse(req.roomId(), req.sender(), req.text(), timeProvider.now());
		template.convertAndSend("/topic/room." + req.roomId(), res);
	}

}
