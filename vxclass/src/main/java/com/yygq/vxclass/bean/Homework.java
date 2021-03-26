package com.yygq.vxclass.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2021/1/3 13:57
 */
@Data
@EqualsAndHashCode
public class Homework {
    private Integer id;
    private Integer classId;
    private String time;
    private String Introducion;
    private String title;
}
