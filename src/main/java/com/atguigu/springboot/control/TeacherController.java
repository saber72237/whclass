package com.atguigu.springboot.control;

import com.atguigu.springboot.bean.Class;
import com.atguigu.springboot.bean.Teacher;
import com.atguigu.springboot.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.Collection;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2021/1/8 14:23
 */
@Controller
public class TeacherController {

    @Autowired
    ITeacherService iTeacherService;

    @GetMapping("/user")
    public String list(Model model, HttpSession session){
        Teacher teachers = iTeacherService.findById((Integer) session.getAttribute("id"));
        model.addAttribute("emps",teachers);
        return "emp/userinfo";
    }
}
