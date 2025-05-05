package com.gruntech.project_management.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class ProjectManagementController {
    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    @ResponseBody
    public String index(){
        return "first return";
    }
}
