package com.atguigu.qqzone.dao;

import com.atguigu.qqzone.pojo.Topic;
import com.atguigu.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * @author Diyang Li
 * @create 2022-04-21 12:37 PM
 */
public interface TopicDAO {
    //获取指定用户的日志列表
    public List<Topic> getTopicList(UserBasic userBasic);
    //添加日志
    public void addTopic(Topic topic);
    //删除日志
    void delTopic(Topic topic);
    //获取特定日志信息
    Topic getTopic(Integer id);
}
