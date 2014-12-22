package jmp.spring.mvc.repository.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import jmp.spring.mvc.model.Employee;
import jmp.spring.mvc.model.Employee_;
import org.springframework.data.jpa.domain.Specification;

public class EmployeeSpecifications {

    public static Specification<Employee> lastNameIsLike(final String searchTerm) {
        return new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> personRoot, CriteriaQuery<?> query, CriteriaBuilder cb) {
                String likePattern = getLikePattern(searchTerm);
                return cb.like(cb.lower(personRoot.<String>get(Employee_.lastName)), likePattern);
            }
            private String getLikePattern(final String searchTerm) {
                StringBuilder pattern = new StringBuilder();
                pattern.append(searchTerm.toLowerCase());
                pattern.append("%");
                return pattern.toString();
            }
        };
    }
}
