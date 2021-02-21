package com.yygq.vxclass.bean;

import lombok.Data;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2021/1/8 19:57
 */
@Data
public class File {
    private Integer id;
    private Integer studentId;
    private Integer homeworkId;
    private String adress;
    private Integer score;
    private Integer state;
    private Integer teacherId;
}
