package com.exampl.Controller;

import com.exampl.domain.ResponseResult;
import com.exampl.domain.User;
import com.exampl.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService service;

    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody User user){
       return service.login(user);
    }
    @GetMapping("/user/logout")
    public ResponseResult logout(){
        return service.logout();
    }
}
