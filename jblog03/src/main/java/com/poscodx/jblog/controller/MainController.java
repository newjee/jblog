package com.poscodx.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/{id}")
public class MainController {

    @Autowired
    private  MainService mainService;

    @RequestMapping("")
    public String main(Model model) {
        blogVo 
        return "blog/main";
    }

}
