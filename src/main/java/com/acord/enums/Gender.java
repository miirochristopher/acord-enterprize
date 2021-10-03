package com.acord.enums;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum Gender {
	M("Male"),
	F("Female");
	
	private final String description;

	Gender(String description) {
		this.description = description;
	}
}
