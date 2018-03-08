package com.hongcheng.fruitmall.mall.dao.mapper;

import com.hongcheng.fruitmall.mall.entity.CommentEntity;

public interface CommentEntityMapper {

    /**
     * 获取商品对应的评论
     * @param productId
     * @return
     */
    CommentEntity getCommentByProductId(Integer productId);

    /**
     * 更新商品评论
     * @param entity
     *
     * @return
     */
    int updateByProductId(CommentEntity entity);

    /**
     * 添加评论（第一条）
     * @param entity
     * @return
     */
    int insert(CommentEntity entity);
}
