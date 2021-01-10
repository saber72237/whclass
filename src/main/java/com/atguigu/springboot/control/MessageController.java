package com.atguigu.springboot.control;

import com.atguigu.springboot.bean.Class;
import com.atguigu.springboot.bean.Message;
import com.atguigu.springboot.service.ClassService;
import com.atguigu.springboot.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collection;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2021/1/8 17:33
 */
@Controller
@RequestMapping("/message")
public class MessageController {
    @Autowired
    MessageService messageService;

    @GetMapping("/emps")
    public String list(Model model, HttpSession session){
        Collection<Message> messages = messageService.findById((Integer) session.getAttribute("id"));
        model.addAttribute("emps",messages);
        return "emp/message";
    }

//    @PostMapping("/add")
//    public String add(@RequestBody Class classes, HttpSession session){
//        classes.setTeacherId((Integer) session.getAttribute("id"));
//        Boolean classVos = classService.addById(classes);
//        return "emp/class";
//    }

    @PostMapping("/update")
    public String update(@RequestBody Message message){
        Boolean classVos = messageService.updateById(message);
        return "emp/message";
    }

//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable("id") Integer id){
//        Boolean classVos = classService.deleteById(id);
//        return "redirect:http://localhost:8080/crud/class/emps";
//    }
}
