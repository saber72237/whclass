package com.yygq.vxclass.control;

import com.yygq.vxclass.bean.Vo.ClassDetailVO;
import com.yygq.vxclass.bean.Vo.ClassSearchVo;
import com.yygq.vxclass.service.ClassService;
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

    @GetMapping("/search")
    @ResponseBody
    public List<ClassSearchVo> classSearch(String search){
        List<ClassSearchVo> classSearchVoList = new ArrayList<ClassSearchVo>();
        classSearchVoList = classService.findByName(search);
        return classSearchVoList;
    }

    @GetMapping("/detail")
    @ResponseBody
    public ClassDetailVO classDetail(Integer id, HttpSession httpSession){
        //Integer userId = Integer.valueOf(httpSession.getAttribute("id").toString());
        Integer userId = 1;
        if (userId.equals("") || userId == null){
            userId = 0;
        }
        ClassDetailVO classDetailVO = new ClassDetailVO();
        classDetailVO = classService.findById(id);
        classDetailVO.setStudentId(userId);
        Integer status = 0;
        status = classService.findStatus(classDetailVO);
        if (status > 0){
            classDetailVO.setStatus(status);
        }
        else {
            classDetailVO.setStatus(0);
        }
        return classDetailVO;
    }

    @GetMapping("/stuClass")
    @ResponseBody
    public List<ClassSearchVo> stuClass(HttpSession httpSession){
        Integer id = (Integer) httpSession.getAttribute("id");
        id = 1;
        List<ClassSearchVo> classSearchVoList = new ArrayList<ClassSearchVo>();
        classSearchVoList = classService.findToId(id);
        return classSearchVoList;
    }
}
