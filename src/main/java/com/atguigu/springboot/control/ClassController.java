package com.atguigu.springboot.control;

import com.atguigu.springboot.bean.Class;
import com.atguigu.springboot.bean.Vo.ClassSearchVo;
import com.atguigu.springboot.bean.Vo.HomeworkVo;
import com.atguigu.springboot.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2021/1/8 13:02
 */
@Controller
@RequestMapping("/class")
public class ClassController {
    @Autowired
    ClassService classService;

    @GetMapping("/emps")
    public String list(Model model, HttpSession session){
        Collection<Class> classes = classService.findById((Integer) session.getAttribute("id"));
        model.addAttribute("emps",classes);
        return "emp/class";
    }

    @PostMapping("/add")
    public String add(@RequestBody Class classes, HttpSession session){
        classes.setTeacherId((Integer) session.getAttribute("id"));
        Boolean classVos = classService.addById(classes);
        return "emp/class";
    }

    @PostMapping("/update")
    public String update(@RequestBody Class classes){
        Boolean classVos = classService.updateById(classes);
        return "emp/class";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        Boolean classVos = classService.deleteById(id);
        return "redirect:http://localhost:8080/crud/class/emps";
    }

    @GetMapping("/search")
    @ResponseBody
    public List<ClassSearchVo> classSearch(String search){
        List<ClassSearchVo> classSearchVoList = new ArrayList<ClassSearchVo>();
        classSearchVoList = classService.findByName(search);
        return classSearchVoList;
    }
}
