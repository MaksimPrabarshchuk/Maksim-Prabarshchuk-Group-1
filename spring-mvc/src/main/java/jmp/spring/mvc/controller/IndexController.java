package jmp.spring.mvc.controller;

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
        model.addAttribute("employees", employeeService.findAll());
        return "index";
    }
}
