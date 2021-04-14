package com.yygq.vxclass.control;

import com.yygq.vxclass.bean.Student;
import com.yygq.vxclass.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Copyright: Copyright (c)2021
 *
 * @author: liuguanzhong
 * @date:
 * @time:
 * @description:
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    IStudentService iStudentService;

    @GetMapping("/user")
    @ResponseBody
    public Student stuClass(String vxId){
        Student student = iStudentService.findByVXId(vxId);
        return student;
    }

    @GetMapping("/stuNo")
    @ResponseBody
    public Boolean stuNo(String stuNo, String vxId){
        Boolean result = iStudentService.setStuNo(stuNo, vxId);
        return result;
    }

}
