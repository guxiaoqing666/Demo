package com.example.springbooterror.controller;

import com.example.springbooterror.exception.TulingException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {

    @RequestMapping("/error1")
    public String error() throws Exception {
        throw new TulingException(404, "404error");
    }
}
