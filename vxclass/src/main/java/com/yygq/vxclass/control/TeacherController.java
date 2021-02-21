package com.yygq.vxclass.control;

import com.yygq.vxclass.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2021/1/8 14:23
 */
@Controller
public class TeacherController {

    @Autowired
    ITeacherService iTeacherService;

}
