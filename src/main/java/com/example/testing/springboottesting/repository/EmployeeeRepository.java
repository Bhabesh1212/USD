package com.example.testing.springboottesting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testing.springboottesting.model.Employee;

public interface EmployeeeRepository extends JpaRepository<Employee, Long>{

}
