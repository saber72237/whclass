package com.atguigu.springboot.control;

import com.atguigu.springboot.bean.Vo.HomeworkVo;
import com.atguigu.springboot.service.HomeworkService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collection;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2021/1/3 14:12
 */
@Controller
public class HomeworkController {

    @Autowired
    HomeworkService homeworkService;

    @GetMapping("/emps")
    public String list(Model model, HttpSession session){
        Collection<HomeworkVo> homeworkVos = homeworkService.findById((Integer) session.getAttribute("id"));
        model.addAttribute("emps",homeworkVos);
        return "emp/list";
    }

    @PostMapping("/add")
    public String add(@RequestBody HomeworkVo homeworkVo){
        Boolean homeworkVos = homeworkService.addById(homeworkVo);
        return "emp/list";
    }

    @PostMapping("/update")
    public String update(@RequestBody HomeworkVo homeworkVo){
        Boolean homeworkVos = homeworkService.updateById(homeworkVo);
        return "emp/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        Boolean homeworkVos = homeworkService.deleteById(id);
        return "redirect:http://localhost:8080/crud/emps";
    }
}
