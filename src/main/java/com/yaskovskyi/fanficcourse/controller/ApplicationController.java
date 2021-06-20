package com.yaskovskyi.fanficcourse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ApplicationController {

    @GetMapping({"/index"})
    public String viewHomePage(Model model){
        return "index";
    }

//    @GetMapping("/registration")
//    public String registerUser(Model model) {
//        return "";
//    }


}
