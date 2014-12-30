package jmp.spring.mvc.service;

import java.util.List;

import jmp.spring.mvc.model.Employee;

public interface EmployeeService {

    Employee findEmployeeById(long employeeId);
    
    Employee findEmployee(String firstName, String lastName);
	
	Employee saveEmployee(Employee employee);

	List<Employee> findAll();
	
    List<Employee> search(String searchTerm);

    void removeEmployee(long employeeId);
}
