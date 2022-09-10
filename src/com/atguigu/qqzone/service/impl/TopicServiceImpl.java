package com.atguigu.qqzone.service.impl;

import com.atguigu.myssm.basedao.DAOException;
import com.atguigu.qqzone.dao.TopicDAO;
import com.atguigu.qqzone.pojo.Reply;
import com.atguigu.qqzone.pojo.Topic;
import com.atguigu.qqzone.pojo.UserBasic;
import com.atguigu.qqzone.service.ReplyService;
import com.atguigu.qqzone.service.TopicService;
import com.atguigu.qqzone.service.UserBasicService;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * @author Diyang Li
 * @create 2022-04-25 12:37 PM
 */
public class TopicServiceImpl implements TopicService {
    private TopicDAO topicDAO ;
    private ReplyService replyService ;
    private UserBasicService userBasicService ;
    @Override
    public List<Topic> getTopicList(UserBasic userBasic) {
        return topicDAO.getTopicList(userBasic);
    }

    public Topic getTopic(Integer id){
        Topic topic  = topicDAO.getTopic(id);
        UserBasic author = userBasicService.getUserBasicById(topic.getAuthor().getId());
        topic.setAuthor(author);
        return topic;
    }

    @Override
    public void delTopicById(Integer id) {
        Topic topic = topicDAO.getTopic(id);
        if (topic!=null){
            replyService.delReplyList(topic);
            topicDAO.delTopic(topic);
        }
    }

    @Override
    public Topic getTopicById(Integer id) {
        Topic topic = getTopic(id);
        List<Reply> replyList = replyService.getReplyListByTopicId(topic.getId());
        topic.setReplyList(replyList);
        return topic;
    }

}
