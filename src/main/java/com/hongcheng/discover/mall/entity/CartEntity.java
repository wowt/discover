package com.hongcheng.discover.mall.entity;

import lombok.Data;

import java.util.List;

@Data
public class CartEntity {
    /**
     * 购物车编号
     */
    private Integer cartId;

    /**
     * 用户编号
     */
    private Integer userId;

    /**
     * 商品列表
     */
    private List<Integer> productIds;

}
