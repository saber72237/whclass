package com.yygq.vxclass.control;

import com.yygq.vxclass.bean.File;
import com.yygq.vxclass.bean.Student;
import com.yygq.vxclass.bean.Vo.FileVo;
import com.yygq.vxclass.service.FileService;
import com.yygq.vxclass.service.IStudentService;
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
 * @date ：2021/1/8 20:24
 */
@Controller
@RequestMapping("/file")
public class FileController {

    @Autowired
    FileService fileService;

    @Autowired
    private IStudentService iStudentService;

    @GetMapping("/history")
    @ResponseBody
    public List<FileVo> history(String vxId){
        List<FileVo> homeworkList = new ArrayList<FileVo>();
        Student student = iStudentService.findByVXId(vxId);
        homeworkList = fileService.history(student.getId());
        return homeworkList;
    }
}
