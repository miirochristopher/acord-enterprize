package com.acord.enums;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum ICYDTool {
	UWESO("UWESO"),
	ACCORD("ACCORD"),
	YOUTH_ACTIVE("YOUTH ACTIVE"),
	IDI("IDI");

	private final String description;

	ICYDTool(String description) {
		this.description = description;
	}
}
