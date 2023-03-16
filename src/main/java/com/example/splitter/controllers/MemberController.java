package com.example.splitter.controllers;

import com.example.splitter.service.AppService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
    AppService service;

    public MemberController(AppService service) {
        this.service = service;
    }


    @GetMapping("/")
    public String getHome(){
        return "index";
    }

}
