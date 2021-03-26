package com.yygq.vxclass.control;

import com.yygq.vxclass.bean.Student;
import com.yygq.vxclass.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private IStudentService iStudentService;

    @ResponseBody
    @PostMapping(value = "/user/login")
    public Boolean login(@RequestParam("vxId") String vxId,
                        Map<String,Object> map, HttpSession session){
        Student student = iStudentService.findByVXId(vxId);
        if(!StringUtils.isEmpty(student.getId())){
            session.setAttribute("loginUser",student.getStuNo());
            session.setAttribute("id",student.getId());
            return true;
        }
        else {
            session.setAttribute("id", null);
            return false;
        }
    }
}
