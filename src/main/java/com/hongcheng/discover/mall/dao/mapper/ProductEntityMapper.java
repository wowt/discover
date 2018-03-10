package com.hongcheng.discover.mall.dao.mapper;

import com.hongcheng.discover.mall.entity.ProductEntity;

public interface ProductEntityMapper {

    ProductEntity selectById(Integer id);

    int insert(ProductEntity entity);

    int update(ProductEntity entity);
}
