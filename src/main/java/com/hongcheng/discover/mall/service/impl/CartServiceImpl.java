package com.hongcheng.discover.mall.service.impl;

import com.hongcheng.discover.mall.dao.mapper.CartEntityMapper;
import com.hongcheng.discover.mall.entity.CartEntity;
import com.hongcheng.discover.mall.service.CartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CartServiceImpl implements CartService {

    @Resource
    private CartEntityMapper mapper;

    @Override
    public void getById() {
        CartEntity entity = mapper.getById(1);
        System.out.println(entity);
    }
}
