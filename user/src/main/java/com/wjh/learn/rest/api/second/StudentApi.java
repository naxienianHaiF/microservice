package com.wjh.learn.rest.api.second;

import com.wjh.learn.common.ResData;
import com.wjh.learn.second.domain.Student;
import com.wjh.learn.second.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student")
public class StudentApi {

    @Autowired
    private StudentMapper studentMapper;

    @GetMapping("/singlestudent")
    public ResData findSingleStudent(Student student) {
        ResData resData = new ResData();
        Student result = studentMapper.selectSingleStudent(student);
        resData.setData(result);
        return resData;
    }
}
