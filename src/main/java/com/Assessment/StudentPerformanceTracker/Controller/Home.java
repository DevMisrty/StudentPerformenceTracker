package com.Assessment.StudentPerformanceTracker.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Home {

    @GetMapping("/")
    public String home(){
        return "Hello world";
    }

    @GetMapping("/home1")
    public String home1(){
        return "Hello world, This is from home1 method ";
    }

}
