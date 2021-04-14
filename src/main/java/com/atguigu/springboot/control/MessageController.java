package com.atguigu.springboot.control;

import com.atguigu.springboot.bean.Class;
import com.atguigu.springboot.bean.Message;
import com.atguigu.springboot.bean.Vo.MessageVo;
import com.atguigu.springboot.service.ClassService;
import com.atguigu.springboot.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
@RequestMapping("/message")
public class MessageController {
    @Autowired
    MessageService messageService;

    @GetMapping("/emps")
    public String list(Model model, HttpSession session){
        Collection<MessageVo> messages = messageService.findById((Integer) session.getAttribute("id"));
        model.addAttribute("emps",messages);
        return "emp/message";
    }

    @PostMapping("/update")
    public String update(@RequestBody Message message){
        message.setState(1);
        Boolean classVos = messageService.updateById(message);
        return "emp/message";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        Boolean classVos = messageService.deleteById(id);
        return "emp/message";
    }
}
