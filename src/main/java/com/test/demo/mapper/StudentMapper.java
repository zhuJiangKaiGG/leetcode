package com.test.demo.mapper;

import com.test.demo.entity.Student;

import java.util.List;

public interface StudentMapper {

    int deleteByPrimaryKey(Integer stdId);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer stdId);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<Student> selectAll();
}
