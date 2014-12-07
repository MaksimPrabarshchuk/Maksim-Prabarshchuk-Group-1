package com.jmp.service.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.jmp.model.Address;
import com.jmp.model.Employee;
import com.jmp.model.Personal;
import com.jmp.service.EmployeeService;
import com.jmp.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class DefaultEmployeeService extends DefaultModelService<Employee>
        implements EmployeeService {

    public DefaultEmployeeService() {
        super(Employee.class);
    }

    @Override
    public void createEmployee(Personal personal, Address address) {
        Employee employee = new Employee(personal, address);
        save(employee);
    }

    @Override
    public List<Employee> searchEmployeeByHireDate(LocalDate hireDate) {
        return session.createCriteria(Employee.class)
                .add(Restrictions.eq("hireDate", hireDate)).list();
    }

    @Override
    public List<Employee> sortEmployeeByAuthorizationDatetimeDesc() {
        return session.createCriteria(Employee.class)
                .addOrder(Order.desc("authorizationDatetime")).list();
    }
}
