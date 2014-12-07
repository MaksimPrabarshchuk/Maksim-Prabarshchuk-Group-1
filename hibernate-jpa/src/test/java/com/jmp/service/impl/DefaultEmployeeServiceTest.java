package com.jmp.service.impl;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.jmp.model.Address;
import com.jmp.model.Employee;

import com.jmp.model.Personal;
import org.junit.Before;
import org.junit.Test;

public class DefaultEmployeeServiceTest {

    private DefaultEmployeeService employeeService;

    @Before
    public void setUp() {
        employeeService = new DefaultEmployeeService();
    }

    @Test
    public void testCreateEmployee() throws Exception {
        Address address = new Address("testAddress");
        Personal personal = new Personal("User", 42);
        Employee employee = new Employee(personal, address);

        employeeService.save(employee);
        Employee em = employeeService.findById(employee.getId());

        assertThat(em, notNullValue());
        assertThat(em.getPersonal(), notNullValue());
        assertThat(em.getPersonal().getName(), equalTo(personal.getName()));
        assertThat(em.getPersonal().getAge(), equalTo(personal.getAge()));
        assertThat(em.getAddress(), notNullValue());
        assertThat(em.getAddress().getFullAddress(), equalTo(address.getFullAddress()));
    }

    @Test
    public void testSearchEmployeeByHireDate() throws Exception {
        Address address = new Address("testAddress");
        Personal personal = new Personal("User", 42);
        Employee employee = new Employee(personal, address);
        LocalDate hireDate = LocalDate.now();
        employee.setHireDate(hireDate);

        employeeService.save(employee);
        List<Employee> ems = employeeService.searchEmployeeByHireDate(hireDate);

        assertThat(ems, hasSize(1));
        assertThat(ems.get(0).getHireDate(), equalTo(hireDate));
    }

    @Test
    public void testSortEmployeeByAuthorizationDatetimeDesc() throws Exception {
        Employee employee1 = new Employee(new Personal("User1", 42),  new Address("testAddress1"));
        LocalDateTime authDateTime1 = LocalDateTime.now();
        employee1.setAuthorizationDatetime(authDateTime1);

        Employee employee2 = new Employee(new Personal("User2", 42), new Address("testAddress2"));
        LocalDateTime authDateTime2 = LocalDateTime.now();
        employee2.setAuthorizationDatetime(authDateTime2);

        employeeService.save(employee1);
        employeeService.save(employee2);

        List<Employee> ems = employeeService.sortEmployeeByAuthorizationDatetimeDesc();

        assertThat(ems, hasSize(2));
        assertThat(ems.get(0).getAuthorizationDatetime(), equalTo(authDateTime2));
        assertThat(ems.get(1).getAuthorizationDatetime(), equalTo(authDateTime1));
    }
}