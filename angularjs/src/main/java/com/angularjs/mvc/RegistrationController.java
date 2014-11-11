package com.angularjs.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegistrationController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "hello";
    }

    @RequestMapping(value = "/reg/new", method = RequestMethod.POST)
    public @ResponseBody
    boolean registration(@RequestBody String form)   {
        return true;
    }
}