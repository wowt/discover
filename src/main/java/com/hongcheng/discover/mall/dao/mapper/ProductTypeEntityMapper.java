package com.hongcheng.discover.mall.dao.mapper;

import com.hongcheng.discover.mall.entity.ProductTypeEntity;

public interface ProductTypeEntityMapper {

    ProductTypeEntity selectById(Integer id);

    int insert(ProductTypeEntity entity);

    int update(ProductTypeEntity entity);

}
