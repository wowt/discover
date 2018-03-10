package com.hongcheng.discover.discover.service;

public interface AdminBiz {

    /**
     * 根据accessToken获取用户id
     *
     * @param accessToken
     * @return
     */
    Integer getUidByAccessToken(String accessToken);
}
