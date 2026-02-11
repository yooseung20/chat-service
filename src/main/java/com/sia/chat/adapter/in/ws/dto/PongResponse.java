package com.sia.chat.adapter.in.ws.dto;

public record PongResponse(
	String text,
	String serverTime


) {
	private static final String PREFIX = "pong: ";

	@Override
	public String text() {
		return PREFIX + text;
	}
}
