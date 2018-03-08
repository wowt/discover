package com.hongcheng.fruitmall.mall.dao.mapper;

import com.hongcheng.fruitmall.mall.entity.UserCollectEntity;

public interface UserCollectEntityMapper {

    UserCollectEntity selectByUserId(Integer userId);

    UserCollectEntity selectById(Integer id);

    int insert(UserCollectEntity entity);

    int delete(Integer id);

}
