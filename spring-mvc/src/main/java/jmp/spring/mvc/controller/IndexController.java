package jmp.spring.mvc.controller;

import jmp.spring.mvc.model.Employee;
import jmp.spring.mvc.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@Autowired
	private EmployeeService employeeService;

    @RequestMapping("/")
    public String index(Model model) {
    	Employee em = new Employee("Mike", "Green");
    	em.setGender("Male");
    	em.setHireDate("12.12.2014");
    	em.setJobTitle("Worker");
    	em.setSalary(42);
    	employeeService.saveEmployee(em);
        model.addAttribute("employees", employeeService.findAll());
        return "index";
    }
}
