package jmp.spring.mvc.service.impl;

import java.util.List;

import jmp.spring.mvc.model.Employee;
import jmp.spring.mvc.repository.EmployeeRepository;
import jmp.spring.mvc.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DefaultEmployeeService implements EmployeeService {
	
	@Autowired
	@Qualifier("employeeRepository")
	private EmployeeRepository employeeRepository;

    @Override
    public Employee findEmployeeById(long employeeId) {
        return employeeRepository.findOne(employeeId);
    }

    @Override
	public Employee saveEmployee(Employee employee) {
		return employee == null ? null : employeeRepository.save(employee);
	}

	@Override
	public List<Employee> search(String searchTerm) {
		return null;
	}

    @Override
    public void removeEmployee(long employeeId) {
        employeeRepository.delete(employeeId);
    }

    @Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}
}
