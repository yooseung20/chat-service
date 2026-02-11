package com.sia.chat.adapter.in.ws.dto;


import jakarta.validation.constraints.NotBlank;

public record PingRequest(
	@NotBlank String text
) {
}
