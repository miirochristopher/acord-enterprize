package com.acord.enums;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum MemberStatus {
	ACTIVE("Active"),
	LOST("Missed-[28days+]"),
	RELOCATED("Relocated-[Unknown]"),
	DROPPED("Dropped"),
	TRANSFERRED_OUT("Transferred Out"),
	DEAD("Died"),
	MISSING_APPOINTMENT("Missing-[7days]");

	private final String description;

	MemberStatus(String description) {
		this.description = description;
	}
}
