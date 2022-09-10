package com.atguigu.qqzone.dao.impl;

import com.atguigu.myssm.basedao.BaseDAO;
import com.atguigu.qqzone.dao.HostReplyDAO;
import com.atguigu.qqzone.pojo.HostReply;

import java.util.List;

/**
 * @author Diyang Li
 * @create 2022-04-25 10:31 AM
 */
public class HostReplyDAOImpl extends BaseDAO<HostReply> implements HostReplyDAO {

    @Override
    public HostReply getHostReplyByReplyId(Integer id) {
        return super.load("SELECT * FROM `t_host_reply` WHERE reply =?", id);
    }

    @Override
    public void addHostReply(HostReply hostReply) {
        super.executeUpdate("INSERT INTO `t_host_reply` VALUES(0,?,?,?,?)", hostReply.getContent(), hostReply.getHostReplyDate(), hostReply.getAuthor().getId(), hostReply.getReply().getId());
    }

    @Override
    public void delHostReply(Integer id) {
        super.executeUpdate("DELETE from `t_host_reply` WHERE `id` =?", id);
    }
}
