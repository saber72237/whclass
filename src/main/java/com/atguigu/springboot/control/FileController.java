package com.atguigu.springboot.control;


import com.atguigu.springboot.bean.Message;
import com.atguigu.springboot.bean.File1;
import com.atguigu.springboot.bean.Vo.FileVo;
import com.atguigu.springboot.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
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

    @RequestMapping("/getImage")
    public void getImagesId(HttpServletResponse rp, String path) {
        String filePath = path;
        File imageFile = new File(filePath);
        if (imageFile.exists()) {
            FileInputStream fis = null;
            OutputStream os = null;
            try {
                fis = new FileInputStream(imageFile);
                os = rp.getOutputStream();
                int count = 0;
                byte[] buffer = new byte[1024 * 8];
                while ((count = fis.read(buffer)) != -1) {
                    os.write(buffer, 0, count);
                    os.flush();
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    fis.close();
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    @PostMapping("/update")
    public String update(@RequestBody File1 file){
        Boolean fileVos = fileService.updateById(file);
        return "emp/file";
    }
}
