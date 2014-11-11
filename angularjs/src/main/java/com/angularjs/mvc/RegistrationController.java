package com.angularjs.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("hello", "formModel", new FormModel());
    }

    @RequestMapping(value = "/reg-new", method = RequestMethod.POST)
    public String registration(@ModelAttribute("formModel") FormModel formModel) {
        return "hello";
    }
}