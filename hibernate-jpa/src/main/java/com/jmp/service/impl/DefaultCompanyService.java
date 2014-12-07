package com.jmp.service.impl;

import com.jmp.model.Employee;
import com.jmp.model.Project;
import com.jmp.model.Unit;
import com.jmp.service.CompanyService;
import com.jmp.service.EmployeeService;
import com.jmp.service.ProjectService;
import com.jmp.service.UnitService;

public class DefaultCompanyService implements CompanyService {

    private EmployeeService employeeService;
    private ProjectService projectService;
    private UnitService unitService;

    public DefaultCompanyService() {
        this.employeeService = new DefaultEmployeeService();
        this.unitService = new DefaultUnitService();
        this.projectService = new DefaultProjectService();
    }

    public DefaultCompanyService(EmployeeService employeeService,
        UnitService unitService, ProjectService projectService) {
        this.employeeService = employeeService;
        this.unitService = unitService;
        this.projectService = projectService;
    }


    @Override
    public boolean addEmployeeToUnitById(long employeeId, long unitId) {
        Employee employee = employeeService.findById(employeeId);
        Unit unit = unitService.findById(unitId);
        if (employee == null || unit == null) {
            return false;
        }
        employee.getUnit().add(unit);
        employeeService.save(employee);
        return true;
    }

    @Override
    public boolean assignEmployeeForProjectById(long employeeId, long projectId) {
        Employee employee = employeeService.findById(employeeId);
        Project project = projectService.findById(projectId);
        if (employee == null || project == null) {
            return false;
        }
        employee.getProject().add(project);
        employeeService.save(employee);
        return true;
    }
}
