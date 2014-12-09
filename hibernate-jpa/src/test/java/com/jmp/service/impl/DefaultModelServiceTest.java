package com.jmp.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.jmp.model.Address;
import com.jmp.model.Employee;
import com.jmp.model.Personal;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class DefaultModelServiceTest {

    private DefaultModelService modelService;
    private Employee employee;

    @Before
    public void setUp() {
        modelService = new DefaultModelService(Employee.class);

        Address address = new Address("testAddress");
        Personal personal = new Personal("User", 42);
        employee = new Employee(personal, address);
        LocalDate hireDate = LocalDate.now();
        LocalDateTime authDateTime = LocalDateTime.now();
        employee.setHireDate(hireDate);
        employee.setAuthorizationDatetime(authDateTime);
    }

    @After
    public void tearDown() {
        modelService.dispose();
    }

    @Test
    public void testSaveAndFindModel() throws Exception {
        modelService.save(employee);
        assertThat(modelService.findById(employee.getId()), notNullValue());
    }

    @Test
    public void testUpdateModel() throws Exception {
        modelService.save(employee);
        Employee em = (Employee) modelService.findById(employee.getId());
        LocalDate now = LocalDate.now();
        em.setHireDate(now);
        modelService.update(employee);
        em = (Employee) modelService.findById(employee.getId());

        assertThat(em, notNullValue());
        assertThat(em.getHireDate(), notNullValue());
        assertThat(em.getHireDate(), equalTo(now));
    }

    @Test
    public void testDeleteModel() throws Exception {
        modelService.save(employee);
        assertThat(modelService.findById(employee.getId()), notNullValue());
        modelService.deleteById(employee.getId());
        assertThat(modelService.findById(employee.getId()), nullValue());
    }
}