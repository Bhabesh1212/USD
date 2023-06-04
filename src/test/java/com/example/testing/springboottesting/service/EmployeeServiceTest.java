package com.example.testing.springboottesting.service;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import com.example.testing.springboottesting.model.Employee;
import com.example.testing.springboottesting.repository.EmployeeeRepository;

public class EmployeeServiceTest {
	
	private EmployeeeRepository employeeeRepository;
	
	private EmployeeService employeeService;
	
	@BeforeEach
	public void setup() {
		employeeeRepository= Mockito.mock(EmployeeeRepository.class);
		employeeService= new EmployeeServiceImpl(employeeeRepository);
		
		
	}
	
	@Test
	public void givenEmployeeObject_whenSaveEmployee_thenReturnEmployeeObject() {
		//given
		Employee employee= Employee.builder().
				firstname("Ramesh").lastname("Barik").email("ramesh@gmail.com").build();
		
		BDDMockito.given(employeeeRepository.findById(employee.getId())).willReturn(Optional.empty());
		System.out.println(employeeeRepository);
		
		BDDMockito.given(employeeeRepository.save(employee)).willReturn(employee);
		//when
		Employee saveEmployee = employeeService.saveEmployee(employee);
		System.out.println(employeeService);
		System.out.println(saveEmployee);
		//then
		
		Assertions.assertThat(saveEmployee).isNotNull();
	}
}
