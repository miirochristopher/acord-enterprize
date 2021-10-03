package com.acord.enums;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum Status {
	YES("Yes"),
	NO("No");
	private final String description;

	Status(String description) {
		this.description = description;
	}
}
