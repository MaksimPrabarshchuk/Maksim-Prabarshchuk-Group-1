package com.jmp.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.jmp.converter.LocalDatePersistenceConverter;
import com.jmp.converter.LocalDateTimePersistenceConverter;

@Entity
@Table
public class Employee {

    @Id
    @GeneratedValue
    @Column(name = "EMPLOYEE_ID")
    private Long id;

    @Embedded
    private Address address;

    @Column
    @Convert(converter = LocalDatePersistenceConverter.class)
    private LocalDate hireDate;

    @Column
    @Convert(converter = LocalDateTimePersistenceConverter.class)
    private LocalDateTime authorizationDatetime;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "employee", cascade = CascadeType.ALL)
    private Personal personal;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "employee_project", joinColumns = {
            @JoinColumn(name = "EMPLOYEE_ID", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "PROJECT_ID", nullable = false, updatable = false) })
    private Set<Project> project;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private Set<Unit> unit;

    public Employee() {
    }

    public Employee(Personal personal, Address address) {
        this.personal = personal;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }

    public Personal getPersonal() {
        return personal;
    }

    public Set<Project> getProject() {
        return project;
    }

    public void setProject(Set<Project> project) {
        this.project = project;
    }

    public Set<Unit> getUnit() {
        return unit;
    }

    public void setUnit(Set<Unit> unit) {
        this.unit = unit;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public LocalDateTime getAuthorizationDatetime() {
        return authorizationDatetime;
    }

    public void setAuthorizationDatetime(LocalDateTime authorizationDatetime) {
        this.authorizationDatetime = authorizationDatetime;
    }
}