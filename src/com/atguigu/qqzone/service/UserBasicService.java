package com.atguigu.qqzone.service;

import com.atguigu.qqzone.pojo.Topic;
import com.atguigu.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * @author Diyang Li
 * @create 2022-04-25 11:51 AM
 */
public interface UserBasicService {
    //登录
    public UserBasic login(String loginId, String pwd);
    //左侧显示是朋友列表
    public List<UserBasic> getFriendList(UserBasic userBasic);
    // 右侧显示日志列表 在topicService中

    /**
     * get UserBasic by ID
     * @param id
     * @return
     */
    public UserBasic getUserBasicById(Integer id);
}

