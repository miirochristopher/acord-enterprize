package com.acord.enums;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum ViralTestDone {
	YES("Yes"),
	NO("No"),
	NE("NE");

	private final String description;

	ViralTestDone(String description) {
		this.description = description;
	}
}
