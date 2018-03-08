package com.hongcheng.fruitmall.mall.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class OrderEntity {

    private Integer orderId;

    /**
     * 商品编号：1，2，3，4
     */
    private String productId;

    /**
     * 购买单价：12，23，23，43
     */
    private String price;

    /**
     * 购买数量：1，2，3，4
     */
    private String productQuantity;

    /**
     * 支付金额
     */
    private float payMoney;

    /**
     * 支付方式
     */
    private String payPath;

    /**
     * 支付时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime payTime;

    /**
     * 订单创建时间
     */
    private LocalDateTime createTime;

    /**
     * 订单状态
     */
    private String state;

    /**
     * 每个商品的积分：1，1，1，1
     */
    private String scoreOne;

    /**
     * 总积分
     */
    private Integer scoreAll;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 下单人编号
     */
    private Integer userId;

    /**
     * 收货地址
     */
    private String userAddress;
}
