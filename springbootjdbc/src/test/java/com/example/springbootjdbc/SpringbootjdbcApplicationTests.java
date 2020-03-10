package com.example.springbootjdbc;

import com.example.springbootjdbc.mapper.DemoMapper;
import com.example.springbootjdbc.po.Demo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@SpringBootTest
class SpringbootjdbcApplicationTests {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private DemoMapper demoMapper;

    @Test
    void contextLoads1() {
        List<Demo> demos = demoMapper.selectList();
        System.out.println(demos.size());
    }
    @Test
    public void testJdbcTemplate() {
        List<Map<String, Object>> employeeList = jdbcTemplate.queryForList("select * from employee");
        System.out.println(employeeList.size());
    }

    @Test
    void contextLoads() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection.getClass());
    }

}
