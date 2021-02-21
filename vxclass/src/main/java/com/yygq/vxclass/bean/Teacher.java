package com.yygq.vxclass.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/12/30 16:57
 */

@Data
@EqualsAndHashCode
public class Teacher {
    private Integer id;
    private String introduce;
    private String username;
    private String name;
    private String age;
    private String gender;
    private String tel;
    private String password;
}
