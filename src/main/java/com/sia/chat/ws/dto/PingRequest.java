package com.sia.chat.ws.dto;


import jakarta.validation.constraints.NotBlank;

public record PingRequest(
	@NotBlank String text
) {
}
