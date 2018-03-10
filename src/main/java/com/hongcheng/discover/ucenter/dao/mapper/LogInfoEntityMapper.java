package com.hongcheng.discover.ucenter.dao.mapper;

import com.hongcheng.discover.ucenter.entity.LogInfoEntity;

public interface LogInfoEntityMapper {

    LogInfoEntity selectByNameAndPassword(String name,String password);

    int insert(LogInfoEntity entity);

}
