package com.sia.chat.adapter.in.ws.dto;

public record ChatSendRequest(
	String sender,
	String text,
	String roomId
) {
}
