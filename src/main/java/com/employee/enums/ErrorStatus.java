package com.employee.enums;

import lombok.Getter;

@Getter
public enum ErrorStatus {

	EMPLOYEE_NAME_REQUIRED(1, "Employee Name is Required", "Employee Name is Required"),
	EMPLOYEE_ID_REQUIRED(2, "Employee id is Required", "Employee id is Required"),
	EMPLOYEE_STATE_MACHINE(3, "Employee state machine is Required", "Employee state machine is Required"),
	EMPLOYEE_NOT_EXIST(4, "Employee Name is not exist", "Employee Name is not exist");

	private Integer id;

	private String message;

	private String description;

	ErrorStatus(Integer id, String message, String description) {
		this.id = id;
		this.message = message;
		this.description = description;
	}

}
