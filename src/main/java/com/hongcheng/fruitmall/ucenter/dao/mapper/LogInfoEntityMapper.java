package com.hongcheng.fruitmall.ucenter.dao.mapper;

import com.hongcheng.fruitmall.ucenter.entity.LogInfoEntity;

public interface LogInfoEntityMapper {

    LogInfoEntity selectByNameAndPassword(String name,String password);

    int insert(LogInfoEntity entity);

}
