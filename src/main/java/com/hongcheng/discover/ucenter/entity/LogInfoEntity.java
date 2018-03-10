package com.hongcheng.discover.ucenter.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class LogInfoEntity {

    private Integer id;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 登录账号
     */
    private String email;

    /**
     * 注册时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime registTime;

    /**
     * 最后一次登录时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastTime;

    /**
     * 用户编号
     */
    private Integer userId;
}
