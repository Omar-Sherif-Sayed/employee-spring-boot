package com.employee.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.employee.dtos.EmployeeDTO;
import com.employee.dtos.ErrorDTO;
import com.employee.entities.Employee;
import com.employee.enums.ErrorStatus;
import com.employee.enums.StateMachine;
import com.employee.repositories.EmployeeRepository;

@Service
@Transactional
public class EmployeeService {

	private Logger logger = LogManager.getLogger(EmployeeService.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	public ResponseEntity<EmployeeDTO> add(EmployeeDTO employeeDTO) {

		List<ErrorDTO> errors = new ArrayList<>();

		if (employeeDTO.getName() == null && employeeDTO.getName().trim().equals("")) {
			errors.add(new ErrorDTO(ErrorStatus.EMPLOYEE_NAME_REQUIRED));
			employeeDTO.setErrors(errors);
			logger.error(ErrorStatus.EMPLOYEE_NAME_REQUIRED.getDescription());
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}

		employeeDTO.setStateMachine(StateMachine.ADDED);

		Employee employee = employeeDTO.toEntity();

		Employee employeeSaved = employeeRepository.save(employee);

		EmployeeDTO employeeDTOAfterSaved = new EmployeeDTO().toDTO(employeeSaved);

		return new ResponseEntity<>(employeeDTOAfterSaved, HttpStatus.OK);
	}

	public ResponseEntity<EmployeeDTO> updateStateMachine(EmployeeDTO employeeDTO) {

		List<ErrorDTO> errors = new ArrayList<>();

		if (employeeDTO.getId() == null) {
			errors.add(new ErrorDTO(ErrorStatus.EMPLOYEE_ID_REQUIRED));
			logger.error(ErrorStatus.EMPLOYEE_ID_REQUIRED.getDescription());
		}

		if (employeeDTO.getStateMachine() == null) {
			errors.add(new ErrorDTO(ErrorStatus.EMPLOYEE_STATE_MACHINE));
			logger.error(ErrorStatus.EMPLOYEE_STATE_MACHINE.getDescription());
		}

		if (!errors.isEmpty()) {
			employeeDTO.setErrors(errors);
			return new ResponseEntity<>(employeeDTO, HttpStatus.NOT_ACCEPTABLE);
		}

		Employee employee = employeeRepository.findEmployeeById(employeeDTO.getId());

		if (employee == null) {
			errors.add(new ErrorDTO(ErrorStatus.EMPLOYEE_NOT_EXIST));
			employeeDTO.setErrors(errors);
			logger.error(ErrorStatus.EMPLOYEE_NOT_EXIST.getDescription());
			return new ResponseEntity<>(employeeDTO, HttpStatus.NOT_ACCEPTABLE);
		}

		employee.setStateMachine(employeeDTO.getStateMachine());

		Employee employeeSaved = employeeRepository.save(employee);

		EmployeeDTO employeeDTOAfterSaved = new EmployeeDTO().toDTO(employeeSaved);

		return new ResponseEntity<>(employeeDTOAfterSaved, HttpStatus.OK);
	}

}
