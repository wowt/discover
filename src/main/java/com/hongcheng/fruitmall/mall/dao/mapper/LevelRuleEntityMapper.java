package com.hongcheng.fruitmall.mall.dao.mapper;

import java.util.List;

import com.hongcheng.fruitmall.mall.entity.LevelRuleEntity;

public interface LevelRuleEntityMapper {

    int insert(LevelRuleEntity entity);

    List<LevelRuleEntity> getAll();

    int update(LevelRuleEntity entity);
}
