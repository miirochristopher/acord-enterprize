package com.acord.enums;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum Regimen {
	 DGT("DGT"),
	 TC3("3TC"),
	 EFV("EFV");
	 
	private final String description;

	Regimen(String description) {
		this.description = description;
	}
}
