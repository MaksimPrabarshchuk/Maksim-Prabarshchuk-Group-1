package com.jmp.service;

import com.jmp.model.Employee;

public interface CompanyService {

    boolean addEmployeeToUnitById(long employeeId, long unitId);

    boolean assignEmployeeForProjectById(long employeeId, long projectId);
}
