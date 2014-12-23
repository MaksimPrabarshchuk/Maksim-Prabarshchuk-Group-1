package jmp.spring.mvc.service;

import java.util.List;

import jmp.spring.mvc.model.Employee;

public interface EmployeeService {
	
	Employee saveEmployee(Employee employee);

	List<Employee> findAll();
	
    List<Employee> search(String searchTerm);
}
