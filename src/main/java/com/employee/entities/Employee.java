package com.employee.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.employee.enums.StateMachine;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee implements Serializable {

	private static final long serialVersionUID = 467393308524600105L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "age")
	private String age;

	@Column(name = "contract_information")
	private String contractInformation;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "state_machine")
	private StateMachine stateMachine;

}
