package jmp.spring.mvc.controller;

import jmp.spring.mvc.model.Employee;
import jmp.spring.mvc.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@Autowired
	private EmployeeService employeeService;

    @RequestMapping("/")
    public String index(@PageableDefault(size = 5, page = 0) Pageable page, Model model) {
        model.addAttribute("page", employeeService.findAll(page));
        return "index";
    }
    
    @RequestMapping("/generateFiveUsers")
    public String createTestData() {
    	for (int i = 0; i < 5; i++) {
        	Employee em = new Employee("Mike", "Green");
        	em.setGender("Male");
        	em.setHireDate("12.12.2014");
        	em.setJobTitle("Worker");
        	em.setSalary(42 + i);
        	employeeService.saveEmployee(em);
    	}
    	return "redirect:/";
    }
}
