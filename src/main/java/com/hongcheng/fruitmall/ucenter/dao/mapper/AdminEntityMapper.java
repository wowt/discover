package com.hongcheng.fruitmall.ucenter.dao.mapper;

import com.hongcheng.fruitmall.ucenter.entity.AdminEntity;

public interface AdminEntityMapper {

    AdminEntity selectById(Integer id);

    AdminEntity selectByNameAndPassword(String name,String password);

    int insert(AdminEntity entity);
}
