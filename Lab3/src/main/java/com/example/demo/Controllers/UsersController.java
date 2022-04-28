package com.example.demo.Controllers;

import com.example.demo.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@RestController

public class UsersController {
    @Autowired
    private UsersService usersService;
    // curl http://localhost:8080/api/users
    @RequestMapping("/api/users")
    @GetMapping
    public Object getUsers(
            @RequestParam(defaultValue = "1") @Min(1) int page_number,
            @RequestParam(defaultValue = "1") @Min(1) @Max(100) int page_size
    ){
        return this.usersService.getPageData(page_number, page_size);
    }
}
