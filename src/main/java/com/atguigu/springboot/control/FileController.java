package com.atguigu.springboot.control;

import com.atguigu.springboot.bean.File;
import com.atguigu.springboot.bean.Message;
import com.atguigu.springboot.bean.Vo.FileVo;
import com.atguigu.springboot.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Collection;

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

    @GetMapping("/emps")
    public String list(Model model, HttpSession session){
        Collection<FileVo> fileVos = fileService.findById((Integer) session.getAttribute("id"));
        model.addAttribute("emps",fileVos);
        return "emp/file";
    }

    @PostMapping("/update")
    public String update(@RequestBody File file){
        Boolean fileVos = fileService.updateById(file);
        return "emp/file";
    }
}
