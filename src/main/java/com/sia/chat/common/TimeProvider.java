package com.sia.chat.common;

import java.time.LocalDateTime;

public interface TimeProvider {
	String nowIso();

	LocalDateTime now();
}
