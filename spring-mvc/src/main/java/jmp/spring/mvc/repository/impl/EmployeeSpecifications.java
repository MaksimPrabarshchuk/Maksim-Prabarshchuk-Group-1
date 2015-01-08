package jmp.spring.mvc.repository.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import jmp.spring.mvc.model.Employee;
import jmp.spring.mvc.model.Employee_;
import org.springframework.data.jpa.domain.Specification;

public class EmployeeSpecifications { 

	public static Specification<Employee> lastNameAndFirstNameIsLike(
			final String firstName, final String lastName) {
        return new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> personRoot, CriteriaQuery<?> query, CriteriaBuilder cb) {
                String likeFirstNamePattern = getLikePattern(firstName);
                String likeLastNamePattern = getLikePattern(lastName);
				return cb.and(
						cb.like(cb.lower(personRoot.<String> get(Employee_.firstName)), likeFirstNamePattern), 
						cb.like(cb.lower(personRoot.<String> get(Employee_.lastName)), likeLastNamePattern));
            }
            private String getLikePattern(final String searchTerm) {
                return searchTerm.toLowerCase() + "%";
            }
        };
    }
}
