package com.employee.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dtos.EmployeeDTO;
import com.employee.services.EmployeeService;

@RestController
@RequestMapping(path = "employee")
public class EmployeeController {

	private Logger logger = LogManager.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@PostMapping(path = "add")
	public ResponseEntity<EmployeeDTO> add(@RequestBody(required = true) EmployeeDTO employeeDTO) {
		try {
			return employeeService.add(employeeDTO);
		} catch (Exception e) {
			logger.error("error in EmployeeController in add() {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(path = "update-state-machine")
	public ResponseEntity<EmployeeDTO> updateStateMachine(@RequestBody(required = true) EmployeeDTO employeeDTO) {
		try {
			return employeeService.updateStateMachine(employeeDTO);
		} catch (Exception e) {
			logger.error("error in EmployeeController in add() {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
