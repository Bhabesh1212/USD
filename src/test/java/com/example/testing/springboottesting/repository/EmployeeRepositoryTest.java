package com.example.testing.springboottesting.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.testing.springboottesting.model.Employee;

@DataJpaTest
public class EmployeeRepositoryTest {
	@Autowired
	private EmployeeeRepository employeeRepository;
	
	//@DisplayName("JUnit test for save employee operation")
	@Test
	public void givenEmployeeObject_whenSave_thenReturnSavedEmployee() {
		//given- preparation or setup
		 
		Employee employee= Employee.builder().
				firstname("Bhabesh").lastname("Ranjan")
				.email("bhabesh@gmail.com").build();
		
		//when- action or behaviour that are going to test
		Employee savedEmployee = employeeRepository.save(employee);
		
		//then- verify the output
		assertThat(savedEmployee).isNotNull();
		assertThat(savedEmployee.getId()).isGreaterThan(0);
	}
	
	//JUnit test for get
	@Test
	public void givenEmployeeList_whenSave_thenReturnEmployeeObject() {
		//given-precondition or setup
		Employee employee= Employee.builder().
				firstname("Bhabesh").lastname("Ranjan")
				.email("bhabesh@gmail.com").build();
		Employee employee1= Employee.builder().
				firstname("Rajesh").lastname("Behera")
				.email("rajesh@gmail.com").build();
		employeeRepository.save(employee);
		employeeRepository.save(employee1);
		//when- action or the behaviour that we are going to test
		
		List<Employee> employeList= employeeRepository.findAll();
		//then- verify the output
		
		assertThat(employeList).isNotNull();
		assertThat(employeList.size()).isEqualTo(2);
	}
	
	//JUNit test for get employee by id operation
	@DisplayName("JUNit test for get employee by id operation")
	@Test
	public void givenEmployeeObject_whenSave_thenReturnObjectByID () {
		//given
		Employee employee= Employee.builder().
				firstname("Bhabesh").lastname("Ranjan")
				.email("bhabesh@gmail.com").build();
		
		employeeRepository.save(employee);
		//when
		Employee edb=employeeRepository.findById(employee.getId()).get();
		
		//then
		assertThat(edb).isNotNull();
	}
	
	
	
	
	


}
