package com.hongcheng.discover.mall.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ConsumeEntity {

    /**
     * 唯一标示
     */
    Integer id;

    /**
     * 用户编号
     */
    Integer userId;

    /**
     * 订单编号
     */
    Integer orderId;

    /**
     * 消费积分
     */
    Integer score;

    /**
     * 日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime date;

    /**
     * 支付方式
     */
    private String payPath;
}
