package com.atguigu.springboot.bean.Vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2021/1/3 14:31
 */
@Data
public class HomeworkVo {
    private Integer id;
    private Integer classId;
    private String name;
    private String title;
    private String introducion;
    private String time;
    private String year;
    private String month;
    private String day;
}
