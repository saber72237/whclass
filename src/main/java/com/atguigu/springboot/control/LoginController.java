package com.atguigu.springboot.control;

import com.atguigu.springboot.bean.Teacher;
import com.atguigu.springboot.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

        @Autowired
    private ITeacherService iTeacherService;

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
        Teacher teacher = iTeacherService.findByName(username);
        if(username.equals(teacher.getUsername())&&password.equals(teacher.getPassword())){
            session.setAttribute("loginUser",username);
            session.setAttribute("id",teacher.getId());
            return "redirect:/user";
        }
        else {
            map.put("msg","用户名密码错误");
            return "redirect:/login/login";
        }
    }
}
