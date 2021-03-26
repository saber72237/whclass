package com.atguigu.springboot.bean;

import lombok.Data;

/**
 * Copyright: Copyright (c)2021
 *
 * @author: liuguanzhong
 * @date:
 * @time:
 * @description:
 */
@Data
public class Doclist {
    private Integer id;
    private String name;
    private Integer prefixId;
    private Integer classId;
    private String password;
    private String path;
}
