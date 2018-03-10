package com.hongcheng.discover.mall.dao.mapper;

import java.util.List;

import com.hongcheng.discover.mall.entity.ConsumeEntity;

public interface ConsumeEntityMapper {

    int insert(ConsumeEntity entity);

    List<ConsumeEntity> getByUserId(Integer userId);

    ConsumeEntity getByOrderId(Integer orderId);
}
