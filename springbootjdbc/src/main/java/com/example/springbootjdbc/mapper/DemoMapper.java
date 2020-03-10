package com.example.springbootjdbc.mapper;

import com.example.springbootjdbc.po.Demo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DemoMapper {

    @Select("select * from demo")
    public List<Demo> selectList();
}
