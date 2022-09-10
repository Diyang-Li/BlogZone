package com.atguigu.qqzone.service.impl;

import com.atguigu.qqzone.dao.ReplyDAO;
import com.atguigu.qqzone.dao.impl.HostReplyDAOImpl;
import com.atguigu.qqzone.dao.impl.ReplyDAOImpl;
import com.atguigu.qqzone.pojo.HostReply;
import com.atguigu.qqzone.pojo.Reply;
import com.atguigu.qqzone.pojo.Topic;
import com.atguigu.qqzone.pojo.UserBasic;
import com.atguigu.qqzone.service.HostReplyService;
import com.atguigu.qqzone.service.ReplyService;
import com.atguigu.qqzone.service.UserBasicService;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Diyang Li
 * @create 2022-05-03 10:11 AM
 */
public class ReplyServiceImpl implements ReplyService {
    private ReplyDAO replyDAO = null;
    //此处引入的是其他POJO对应的Service接口，而不是DAO接口
    //其他POJO对应的业务逻辑是封装在service层的，我需要调用别人的业务逻辑方法，而不要去深入考虑人家内部的细节
    private HostReplyService hostReplyService = null;
    private UserBasicService userBasicService;

    @Override
    public List<Reply> getReplyListByTopicId(Integer id) {
        List<Reply> replyList = replyDAO.getReplyList(new Topic(id));
        for (int i = 0; i < replyList.size(); i++) {
            Reply reply = replyList.get(i);

            //这里的逻辑是这样的：
            //basicDAO会根据<T> 把获取到的值封装到T的attribute上，但是问题是reply table中只有author的id，
            //所以无法获取完整的userBasic，那么我么就可以通过reply的authorID加上userbasicservice得到一个完整的
            //userbasic实例，再set回reply中即可
            UserBasic author = userBasicService.getUserBasicById(reply.getAuthor().getId());
            reply.setAuthor(author);

            HostReply hostReply = hostReplyService.getHostReplyListById(reply.getId());
            reply.setHostReply(hostReply);
        }
        return replyList;
    }

    @Override
    public void addReply(Reply reply) {
        replyDAO.addReply(reply);
    }

    @Override
    public void delReply(Integer replyId) {
        Reply reply = replyDAO.getReply(replyId);
        if (reply != null) {
            HostReply hostReply = hostReplyService.getHostReplyListById(replyId);
            if (hostReply!=null){
                hostReplyService.delHostReply(hostReply.getId());
            }
            replyDAO.delReply(replyId);
        }
    }

    @Override
    public void delReplyList(Topic topic) {
        List<Reply> replyList = replyDAO.getReplyList(topic);
        if (replyList!=null){
            for (Reply reply: replyList){
                delReply(reply.getId());
            }
        }
    }
}