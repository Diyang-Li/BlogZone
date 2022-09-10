package com.atguigu.qqzone.service;

import com.atguigu.qqzone.pojo.HostReply;

import java.util.List;

/**
 * @author Diyang Li
 * @create 2022-05-03 10:29 AM
 */
public interface HostReplyService {
    public HostReply getHostReplyListById(Integer id);
    void addHostReply(HostReply hostReply);
    void delHostReply(Integer id);
}
