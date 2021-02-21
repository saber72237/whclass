package com.yygq.vxclass;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan({"com.yygq.vxclass.mapper"})
@SpringBootApplication
public class VxclassApplication {

    public static void main(String[] args) {
        SpringApplication.run(VxclassApplication.class, args);
    }

}
