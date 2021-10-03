package com.acord.enums;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum Adherence {
	GOOD("Good"),
	FAIR("Fair"),
	POOR("Poor");

	private final String description;

	Adherence(String description) {
		this.description = description;
	}
}
