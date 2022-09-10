package com.atguigu.qqzone.dao;

import com.atguigu.qqzone.pojo.Reply;
import com.atguigu.qqzone.pojo.Topic;

import java.util.List;

/**
 * @author Diyang Li
 * @create 2022-04-21 12:39 PM
 */
public interface ReplyDAO {
    //获取指定日志的回复列表
    List<Reply> getReplyList(Topic topic);
    //添加回复
    void addReply(Reply reply);
    //删除回复
    void delReply(Integer id);

    /**
     * Get Reply by replyId
     * @param id
     * @return
     */
    Reply getReply(Integer id);
}
