package com.example.springbootfilter.controller;

import com.example.springbootfilter.anno.DemoLogAnno;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/hi")
    @DemoLogAnno
    public String test(@RequestParam("name") String  name) {
        return "hi";
    }
}
