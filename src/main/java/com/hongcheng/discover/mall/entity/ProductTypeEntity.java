package com.hongcheng.discover.mall.entity;

import lombok.Data;

@Data
public class ProductTypeEntity {

    /**
     * 类型编号
     */
    private Integer typeId;

    /**
     * 类型名字
     */
    private String typeName;

    /**
     * 类型状态
     */
    private String typeState;

}
