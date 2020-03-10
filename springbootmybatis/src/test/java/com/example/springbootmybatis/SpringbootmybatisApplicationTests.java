package com.example.springbootmybatis;

import com.example.springbootmybatis.mapper.DemoMapper;
import com.example.springbootmybatis.po.Demo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootmybatisApplicationTests {

    @Autowired
    private DemoMapper demoMapper;

    @Test
    void contextLoads() {
        List<Demo> demos = demoMapper.selectList();
        System.out.println(demos.size());
    }

}
