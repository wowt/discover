package com.hongcheng.discover.ucenter.dao.mapper;

import com.hongcheng.discover.ucenter.entity.UserEntity;

public interface UserEntityMapper {

    UserEntity selectById(Integer userId);

    int insert(UserEntity entity);

}
