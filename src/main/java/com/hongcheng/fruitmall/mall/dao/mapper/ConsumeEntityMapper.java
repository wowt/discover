package com.hongcheng.fruitmall.mall.dao.mapper;

import java.util.List;

import com.hongcheng.fruitmall.mall.entity.CommentEntity;
import com.hongcheng.fruitmall.mall.entity.ConsumeEntity;

public interface ConsumeEntityMapper {

    int insert(ConsumeEntity entity);

    List<ConsumeEntity> getByUserId(Integer userId);

    ConsumeEntity getByOrderId(Integer orderId);
}
