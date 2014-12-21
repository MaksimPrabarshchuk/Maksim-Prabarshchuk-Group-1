package jmp.spring.mvc.service;

import java.util.List;

import jmp.spring.mvc.model.Employee;

public interface EmployeeService {

    List<Employee> search(String searchTerm);
}
