package com.hongcheng.fruitmall.ucenter.entity;

import lombok.Data;

@Data
public class UserAddressEntity {

    /**
     * 唯一标示
     */
    private Integer id;

    /**
     * 用户编号
     */
    private Integer userId;

    /**
     * 电话
     */
    private Long userTelPhone;

    /**
     * 地址
     */
    private String userAddress;

    /**
     * 邮编
     */
    private Integer postCode;
}
