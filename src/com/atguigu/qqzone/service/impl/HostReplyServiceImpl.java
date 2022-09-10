package com.atguigu.qqzone.service.impl;

import com.atguigu.qqzone.dao.HostReplyDAO;
import com.atguigu.qqzone.pojo.HostReply;
import com.atguigu.qqzone.service.HostReplyService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Diyang Li
 * @create 2022-05-03 10:29 AM
 */
public class HostReplyServiceImpl implements HostReplyService {
    private HostReplyDAO hostReplyDAO = null;
    @Override
    public HostReply getHostReplyListById(Integer id) {
        return hostReplyDAO.getHostReplyByReplyId(id);
    }

    @Override
    public void addHostReply(HostReply hostReply) {
        hostReplyDAO.addHostReply(hostReply);
    }

    @Override
    public void delHostReply(Integer id) {
        hostReplyDAO.delHostReply(id);
    }
}
