package jmp.spring.mvc.controller;

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
        model.addAttribute("employees", employeeService.findAll(page));
        return "index";
    }
}
