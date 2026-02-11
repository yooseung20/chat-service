package com.sia.chat.adapter.in.ws.dto;

import java.time.LocalDateTime;

public record ChatSendResponse(
	String roomId,
	String sender,
	String text,
	LocalDateTime sentAt

) {
}
