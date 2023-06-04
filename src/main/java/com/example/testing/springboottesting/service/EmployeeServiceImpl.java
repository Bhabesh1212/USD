package com.example.testing.springboottesting.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testing.springboottesting.exception.ResourceNotFoundException;
import com.example.testing.springboottesting.model.Employee;
import com.example.testing.springboottesting.repository.EmployeeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	private EmployeeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeeRepository employeeeRepository) {
		this.employeeRepository=employeeeRepository;
		// TODO Auto-generated constructor stub
	}
	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Optional<Employee> savedEmployee = employeeRepository.findById(employee.getId());
		
		if(savedEmployee.isPresent()) {
			throw new ResourceNotFoundException("Employee Already Present with that given ID");
		}
		return employeeRepository.save(employee);
	}

}
