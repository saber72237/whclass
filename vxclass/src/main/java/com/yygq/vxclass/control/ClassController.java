package com.yygq.vxclass.control;

import com.yygq.vxclass.bean.ClassDTO;
import com.yygq.vxclass.bean.Student;
import com.yygq.vxclass.bean.Vo.ClassDetailVO;
import com.yygq.vxclass.bean.Vo.ClassSearchVo;
import com.yygq.vxclass.service.ClassService;
import com.yygq.vxclass.service.IStudentService;
import com.yygq.vxclass.service.impl.StudentServiceImpl;
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

    @Autowired
    IStudentService iStudentService;

    @GetMapping("/search")
    @ResponseBody
    public List<ClassSearchVo> classSearch(String search){
        List<ClassSearchVo> classSearchVoList = new ArrayList<ClassSearchVo>();
        classSearchVoList = classService.findByName(search);
        return classSearchVoList;
    }

    @GetMapping("/detail")
    @ResponseBody
    public ClassDetailVO classDetail(Integer id, String vxId, HttpSession httpSession){
        Integer userId = iStudentService.findByVXId(vxId).getId();
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
    public List<ClassSearchVo> stuClass(HttpSession httpSession, String id){
        Student student = iStudentService.findByVXId(id);
        List<ClassSearchVo> classSearchVoList = new ArrayList<ClassSearchVo>();
        classSearchVoList = classService.findToId(student.getId());
        return classSearchVoList;
    }

    @PostMapping("/update")
    @ResponseBody
    public String update(@RequestBody ClassDTO classDTO){
        Student student = iStudentService.findByVXId(classDTO.getVxId());
        Boolean checkList = true;
        Boolean classVos = classService.updateState(checkList, student.getId(), classDTO.getClassId());
        return "success";
    }
}
