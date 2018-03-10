package com.hongcheng.discover.mall.dao.mapper;

import java.util.List;

import com.hongcheng.discover.mall.entity.OrderEntity;

public interface OrderEntityMapper {

    OrderEntity selectByOrderId(Integer orderId);

    List<OrderEntity> selectByUserId(Integer userId);

    int insert(OrderEntity orderEntity);
}
