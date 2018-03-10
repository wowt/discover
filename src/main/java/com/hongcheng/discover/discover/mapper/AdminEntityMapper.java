package com.hongcheng.discover.discover.mapper;

import com.hongcheng.discover.discover.entity.AdminEntity;

public interface AdminEntityMapper {

    AdminEntity selectById(Integer id);

    Integer selectByNameAndPassword(String name, String password);

    int insert(AdminEntity entity);
}
