package com.exampl.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
//    @PreAuthorize("hasAnyAuthority('test')")
    @PreAuthorize("hasAuthority('user')")
    public String hello(){
        return "lma,hello";
    }
}
