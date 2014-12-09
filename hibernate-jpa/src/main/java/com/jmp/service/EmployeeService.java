package com.jmp.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.jmp.model.Address;
import com.jmp.model.Employee;
import com.jmp.model.Personal;

public interface EmployeeService extends ModelService<Employee> {

    void createEmployee(Personal personal, Address address);

    List<Employee> searchEmployeeByHireDate(LocalDate hireDate);

    List<Employee> sortEmployeeByAuthorizationDatetimeDesc();
}
