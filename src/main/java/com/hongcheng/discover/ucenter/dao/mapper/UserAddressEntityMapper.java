package com.hongcheng.discover.ucenter.dao.mapper;

import java.util.List;

import com.hongcheng.discover.ucenter.entity.UserAddressEntity;

public interface UserAddressEntityMapper {

    List<UserAddressEntity> selectByUserId(Integer userId);

    int insert(UserAddressEntity entity);

}
