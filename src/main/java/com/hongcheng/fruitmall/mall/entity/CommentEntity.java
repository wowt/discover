package com.hongcheng.fruitmall.mall.entity;

import lombok.Data;

@Data
public class CommentEntity {
    /**
     * 评论编号
     */
    private Integer commentId;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 商品编号
     */
    private Integer productId;

    /**
     * 评论次数
     */
    private Integer commentCount;

}
