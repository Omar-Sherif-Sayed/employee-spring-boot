package com.employee;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.employee.entities.Employee;
import com.employee.enums.StateMachine;
import com.employee.repositories.EmployeeRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class EmployeeApplicationTests {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Test
	void addEmployeeTestCase() {
		Employee employee = new Employee();
		employee.setName("Omar");
		employee.setAge("27");
		employee.setContractInformation("Lab lab La");
		employee.setStateMachine(StateMachine.ADDED);

		Employee employeeAfterSaved = employeeRepository.save(employee);
		assertNotNull(employeeAfterSaved);
		assertNotNull(employeeAfterSaved.getId());
		assertNotNull(employeeAfterSaved.getName());
		assertNotNull(employeeAfterSaved.getAge());
		assertNotNull(employeeAfterSaved.getStateMachine());
	}

}
