package com.hongcheng.fruitmall.mall.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ProductEntity {

    /**
     * 产品编号
     */
    private Integer productId;

    /**
     * 产品名字
     */
    private String productName;

    /**
     * 产地
     */
    private String productPlace;

    /**
     * 现在状态
     */
    private String productState;

    /**
     * 属于什么类型
     */
    private Integer productType;

    /**
     * 图片URL
     */
    private String productImg;

    /**
     * tips
     */
    private String tips;

    /**
     * 单价 /kg
     */
    private float price;

    /**
     * 折扣价
     */
    private float dealPrice;

    /**
     * 购买1kg可以获得多少积分
     */
    private float score;

    /**
     * 开始销售时间
     */
    private LocalDateTime startTime;

    /**
     * 止时间
     */
    private LocalDateTime endTime;

    /**
     * 介绍
     */
    private String introduce;
}
