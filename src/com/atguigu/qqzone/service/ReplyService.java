package com.atguigu.qqzone.service;

import com.atguigu.qqzone.pojo.HostReply;
import com.atguigu.qqzone.pojo.Reply;
import com.atguigu.qqzone.pojo.Topic;

import java.util.List;

/**
 * @author Diyang Li
 * @create 2022-05-03 10:00 AM
 */
public interface ReplyService {
    List<Reply> getReplyListByTopicId(Integer id);
    void addReply(Reply reply);
    void delReply(Integer replyId);

    /**
     * Delete all reply related to a topic
     * @param topic
     */
    void delReplyList(Topic topic);
}
