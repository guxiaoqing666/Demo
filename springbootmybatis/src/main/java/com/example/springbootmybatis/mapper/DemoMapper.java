package com.example.springbootmybatis.mapper;

import com.example.springbootmybatis.po.Demo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DemoMapper {

    @Select("select * from demo")
    public List<Demo> selectList();
}
