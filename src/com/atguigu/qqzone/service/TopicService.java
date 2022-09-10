package com.atguigu.qqzone.service;

import com.atguigu.qqzone.pojo.Topic;
import com.atguigu.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * @author Diyang Li
 * @create 2022-04-25 12:35 PM
 */
public interface TopicService {
    /**
     * 查询特定用户的topic list
     * @param userBasic
     * @return
     */
    List<Topic> getTopicList(UserBasic userBasic);
    Topic getTopicById(Integer id);
    //通过topic id 获取topic,并且用userbasicservice通过topic author的id找到userbasic，反过来把userbasic的信息再赋值给topic的author
    Topic getTopic(Integer id);
    void delTopicById(Integer id);
}
