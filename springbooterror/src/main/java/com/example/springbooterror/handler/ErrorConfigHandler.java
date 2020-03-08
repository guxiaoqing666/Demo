package com.example.springbooterror.handler;

import com.example.springbooterror.exception.TulingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

//@ControllerAdvice
public class ErrorConfigHandler {


    @ExceptionHandler(value = TulingException.class)
    public String dealException(TulingException e, HttpServletRequest request) {
        Map<String, Object> retInfo = new HashMap<>();
        retInfo.put("code", e.getCode());
        retInfo.put("msg", e.getMsg());
        request.setAttribute("javax.servlet.error.status_code", 500);
        request.setAttribute("ext", retInfo);
        return "forward:/error";
    }
}
