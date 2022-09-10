package com.atguigu.qqzone.controller;

import com.atguigu.qqzone.pojo.Reply;
import com.atguigu.qqzone.pojo.Topic;
import com.atguigu.qqzone.pojo.UserBasic;
import com.atguigu.qqzone.service.ReplyService;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author Diyang Li
 * @create 2022-05-04 10:47 AM
 */
public class ReplyController {
    ReplyService replyService;

    public String addReply(String content, Integer topicId, HttpSession session) {
        // topic id 可以从session获取，也可以从页面获取
        UserBasic userBasic = (UserBasic) session.getAttribute("userBasic");
        Reply reply = new Reply(content, new Date(), userBasic, new Topic(topicId));
        replyService.addReply(reply);
        return "redirect:topic.do?operate=topicDetail&id=" + topicId;
    }

    public String delReply(Integer replyId, Integer topicId){
        replyService.delReply(replyId);
        return "redirect:topic.do?operate=topicDetail&id="+topicId;
    }
}
