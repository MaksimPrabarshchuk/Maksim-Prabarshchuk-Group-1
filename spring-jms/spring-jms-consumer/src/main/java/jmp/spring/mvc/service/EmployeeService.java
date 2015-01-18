package jmp.spring.mvc.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jmp.spring.mvc.model.Employee;

public interface EmployeeService {
	
	List<Employee> findAll();

	Page<Employee> findAll(Pageable page);

    Employee findEmployeeById(long employeeId);
    
    Employee findEmployee(String firstName, String lastName);
	
	Employee saveEmployee(Employee employee);
	
    List<Employee> search(String searchTerm);

    void removeEmployee(long employeeId);
}
