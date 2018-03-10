package com.hongcheng.discover.mall.dao.mapper;

import java.util.List;

import com.hongcheng.discover.mall.entity.LevelRuleEntity;

public interface LevelRuleEntityMapper {

    int insert(LevelRuleEntity entity);

    List<LevelRuleEntity> getAll();

    int update(LevelRuleEntity entity);
}
