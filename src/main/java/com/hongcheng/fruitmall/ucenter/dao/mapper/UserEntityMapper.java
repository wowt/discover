package com.hongcheng.fruitmall.ucenter.dao.mapper;

import com.hongcheng.fruitmall.ucenter.entity.UserEntity;

public interface UserEntityMapper {

    UserEntity selectById(Integer userId);

    int insert(UserEntity entity);

}
