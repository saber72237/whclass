package com.yygq.vxclass.bean;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2021/1/8 17:21
 */
@Data
public class Message {
    private Integer id;
    private String title;
    private Integer authorId;
    private LocalDateTime creatTime;
    private Integer teacherId;
    private LocalDateTime endTime;
    private String request;
    private String response;
    private Integer state;
    private Integer classId;
}
