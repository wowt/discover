package com.hongcheng.discover.mall.dao.mapper;

import com.hongcheng.discover.mall.entity.UserCollectEntity;

public interface UserCollectEntityMapper {

    UserCollectEntity selectByUserId(Integer userId);

    UserCollectEntity selectById(Integer id);

    int insert(UserCollectEntity entity);

    int delete(Integer id);

}
