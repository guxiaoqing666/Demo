package com.example.springbootjdbc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class testController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/test")
    public String test(){
        List<Map<String, Object>> employeeList = jdbcTemplate.queryForList("select * from employee");
        System.out.println(employeeList.size());
        return "ok";
    }
}
