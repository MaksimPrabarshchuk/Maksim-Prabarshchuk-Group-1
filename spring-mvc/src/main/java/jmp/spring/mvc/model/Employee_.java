package jmp.spring.mvc.model;

import java.time.LocalDate;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Employee.class)
public class Employee_{

    public static volatile SingularAttribute<Employee, Long> id;
    public static volatile SingularAttribute<Employee, String> firstName;
    public static volatile SingularAttribute<Employee, String> lastName;
    public static volatile SingularAttribute<Employee, String> gender;
    public static volatile SingularAttribute<Employee, LocalDate> hireDate;
    public static volatile SingularAttribute<Employee, String> jobTitle;
    public static volatile SingularAttribute<Employee, Double> salary;
}
