package com.acord.enums;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum FollowUpMeans {
	PHONE("Phone Call"),
	VISIT("Home Visits"),
	FACILITY("Facility Visits");
	
	private final String description;

	FollowUpMeans(String description) {
		this.description = description;
	}
}
