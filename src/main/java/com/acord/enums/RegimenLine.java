package com.acord.enums;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum RegimenLine {
	ST("1st"),
	ND("2nd"),
	RD("3rd");

	private final String description;

	RegimenLine(String description) {
		this.description = description;
	}
}
