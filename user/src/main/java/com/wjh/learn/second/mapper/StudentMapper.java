package com.wjh.learn.second.mapper;

import com.wjh.learn.second.domain.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {

    Student selectSingleStudent(Student student);
}
