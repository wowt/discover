package com.hongcheng.fruitmall.mall.dao.mapper;

import java.util.List;

import com.hongcheng.fruitmall.mall.entity.OrderEntity;

public interface OrderEntityMapper {

    OrderEntity selectByOrderId(Integer orderId);

    List<OrderEntity> selectByUserId(Integer userId);

    int insert(OrderEntity orderEntity);
}
