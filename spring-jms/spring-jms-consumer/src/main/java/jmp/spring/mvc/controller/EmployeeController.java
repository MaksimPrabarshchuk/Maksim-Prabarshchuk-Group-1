package jmp.spring.mvc.controller;

import java.util.List;

import jmp.spring.mvc.model.Employee;
import jmp.spring.mvc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

    @RequestMapping(value = "/getEmployees", method = RequestMethod.POST)
    public @ResponseBody List<Employee> getEmployees() {
        return employeeService.findAll();
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
    public String addEmployeePage() {
        return "addEmployee";
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }
    
    @RequestMapping(value = "/findEmployee", method = RequestMethod.POST)
	public @ResponseBody String findEmployee(@ModelAttribute("fistName") String firstName,
			@ModelAttribute("lastName") String lastName, Model model) {
    	Employee em = employeeService.findEmployee(firstName, lastName);
    	return em == null ? "0" : String.valueOf((em.getId()));
    }

    @RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
    public String editEmployeePage(@ModelAttribute("id") long id, Model model) {
        model.addAttribute("employee", employeeService.findEmployeeById(id));
        return "editEmployee";
    }

    @RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
    public String updateEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @RequestMapping(value = "/removeEmployee", method = RequestMethod.GET)
    public String removeEmployee(@ModelAttribute("id") long id) {
        employeeService.removeEmployee(id);
        return "redirect:/";
    }
}
