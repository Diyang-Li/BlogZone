package com.atguigu.qqzone.dao;

import com.atguigu.qqzone.pojo.HostReply;
import com.atguigu.qqzone.pojo.Reply;

import java.util.List;

/**
 * @author Diyang Li
 * @create 2022-04-21 12:40 PM
 */
public interface HostReplyDAO {
    public HostReply getHostReplyByReplyId(Integer id);
    void addHostReply(HostReply hostReply);
    void delHostReply(Integer id);
}
