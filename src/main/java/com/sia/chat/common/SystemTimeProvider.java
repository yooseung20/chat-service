package com.sia.chat.common;

import java.time.Clock;
import java.time.Instant;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SystemTimeProvider implements TimeProvider {

	private final Clock clock;

	@Override
	public String nowIso() {
		return Instant.now(clock).toString();
	}
}
