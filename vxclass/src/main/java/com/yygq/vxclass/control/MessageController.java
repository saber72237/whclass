package com.yygq.vxclass.control;

import com.yygq.vxclass.bean.Doclist;
import com.yygq.vxclass.bean.Message;
import com.yygq.vxclass.service.ClassService;
import com.yygq.vxclass.service.ITeacherService;
import com.yygq.vxclass.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    MessageService messageService;

    @Autowired
    ClassService classService;

    @ResponseBody
    @GetMapping("/list")
    public List<Message> list(String classId){
        List<Message> messsages = messageService.findByClassId(Integer.valueOf(classId));
        return messsages;
    }

    @ResponseBody
    @PostMapping("/add")
    public Boolean add(@RequestBody Message message, HttpSession httpSession){
        //Integer id = (Integer) httpSession.getAttribute("id");
        Integer id = 1;
        Integer teacherId = classService.findByClassId(message.getClassId());
        message.setAuthorId(id);
        message.setTeacherId(teacherId);
        Boolean flag = messageService.saveMessage(message);
        return flag;
    }

}
