package com.employee.enums;

import lombok.Getter;

@Getter
public enum StateMachine {

	ADDED(0, "ADDED"), IN_CHECK(1, "IN-CHECK"), APPROVED(2, "APPROVED"), ACTIVE(3, "ACTIVE");

	private StateMachine(Integer id, String value) {
		this.id = id;
		this.value = value;
	}

	private Integer id;

	private String value;

}
