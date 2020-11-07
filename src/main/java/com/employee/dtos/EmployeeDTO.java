package com.employee.dtos;

import java.io.Serializable;
import java.util.List;

import com.employee.entities.Employee;
import com.employee.enums.StateMachine;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeDTO implements Serializable {

	private static final long serialVersionUID = -362363712886982107L;

	private Long id;

	private String name;

	private String age;

	private String contractInformation;

//	@Enumerated(EnumType.STRING)
	private StateMachine stateMachine;

	private List<ErrorDTO> errors;

	public EmployeeDTO toDTO(Employee employee) {
		id = employee.getId();
		name = employee.getName();
		contractInformation = employee.getContractInformation();
		age = employee.getAge();
		stateMachine = employee.getStateMachine();
		return this;
	}

	public Employee toEntity() {
		Employee employee = new Employee();
		employee.setId(id);
		employee.setName(name);
		employee.setContractInformation(contractInformation);
		employee.setAge(age);
		employee.setStateMachine(stateMachine);
		return employee;
	}

}
