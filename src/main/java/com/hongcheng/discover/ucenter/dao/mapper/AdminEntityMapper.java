package com.hongcheng.discover.ucenter.dao.mapper;

import com.hongcheng.discover.ucenter.entity.AdminEntity;

public interface AdminEntityMapper {

    AdminEntity selectById(Integer id);

    AdminEntity selectByNameAndPassword(String name,String password);

    int insert(AdminEntity entity);
}
