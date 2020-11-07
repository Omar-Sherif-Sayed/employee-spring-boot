package com.employee.dtos;

import java.io.Serializable;

import com.employee.enums.ErrorStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;

@Getter
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorDTO implements Serializable {

	private static final long serialVersionUID = 7577057819285454008L;

	public ErrorDTO(ErrorStatus error) {
		this.id = error.getId();
		this.message = error.getMessage();
		this.description = error.getDescription();
	}

	private Integer id;

	private String message;

	private String description;

}
