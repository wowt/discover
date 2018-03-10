package com.hongcheng.discover.discover.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.hongcheng.discover.discover.mapper.AdminEntityMapper;
import com.hongcheng.discover.discover.service.AdminBiz;

public class AdminBizImpl implements AdminBiz {

    @Autowired
    AdminEntityMapper mapper;

    @Override
    public Integer getUidByAccessToken(String accessToken) {
        return null;
    }
}
