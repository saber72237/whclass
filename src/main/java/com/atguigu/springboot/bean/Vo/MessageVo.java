package com.atguigu.springboot.bean.Vo;

import com.atguigu.springboot.bean.Message;
import lombok.Data;

/**
 * @Author: liuGuanZhong
 * @Date: Creat in 2021/4/12
 * @Time: 上午11:17
 * @description:
 * @Modified By:
 */
@Data
public class MessageVo extends Message {

    private String stuNo;

    private String stuName;
}
