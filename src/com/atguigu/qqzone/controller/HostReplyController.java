package com.atguigu.qqzone.controller;

import com.atguigu.qqzone.pojo.HostReply;
import com.atguigu.qqzone.pojo.Reply;
import com.atguigu.qqzone.pojo.UserBasic;
import com.atguigu.qqzone.service.HostReplyService;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author Diyang Li
 * @create 2022-05-04 3:36 PM
 */
public class HostReplyController {
    HostReplyService hostReplyService;
    public String addHostReply(String content, Integer replyId, Integer topicId, HttpSession session){
        UserBasic userBasic = (UserBasic) session.getAttribute("userBasic");
        HostReply hostReply = new HostReply(content, new Date(), userBasic, new Reply(replyId));
        hostReplyService.addHostReply(hostReply);
        return "redirect:topic.do?operate=topicDetail&id=" + topicId;
    }

}
