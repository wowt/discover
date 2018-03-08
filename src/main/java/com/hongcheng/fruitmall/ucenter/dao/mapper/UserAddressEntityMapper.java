package com.hongcheng.fruitmall.ucenter.dao.mapper;

import java.util.List;

import com.hongcheng.fruitmall.ucenter.entity.UserAddressEntity;

public interface UserAddressEntityMapper {

    List<UserAddressEntity> selectByUserId(Integer userId);

    int insert(UserAddressEntity entity);

}
