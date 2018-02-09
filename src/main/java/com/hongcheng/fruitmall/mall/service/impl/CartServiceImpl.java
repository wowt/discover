package com.hongcheng.fruitmall.mall.service.impl;

import com.hongcheng.fruitmall.mall.dao.mapper.CartEntityMapper;
import com.hongcheng.fruitmall.mall.entity.CartEntity;
import com.hongcheng.fruitmall.mall.service.CartService;
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
