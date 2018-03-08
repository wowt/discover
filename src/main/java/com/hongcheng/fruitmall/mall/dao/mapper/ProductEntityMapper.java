package com.hongcheng.fruitmall.mall.dao.mapper;

import com.hongcheng.fruitmall.mall.entity.ProductEntity;

public interface ProductEntityMapper {

    ProductEntity selectById(Integer id);

    int insert(ProductEntity entity);

    int update(ProductEntity entity);
}
