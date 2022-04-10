package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class homeController {
    @RequestMapping("/")
    @ResponseBody
    public String index(){
        return "Hello World!";
    }

    @RequestMapping("/example")
    public String example(){
        return "template";
    }

}
