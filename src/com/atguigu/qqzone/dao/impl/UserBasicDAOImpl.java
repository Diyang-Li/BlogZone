package com.atguigu.qqzone.dao.impl;

import com.atguigu.myssm.basedao.BaseDAO;
import com.atguigu.qqzone.dao.UserBasicDAO;
import com.atguigu.qqzone.pojo.UserBasic;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author Diyang Li
 * @create 2022-04-21 12:41 PM
 */
public class UserBasicDAOImpl extends BaseDAO<UserBasic> implements UserBasicDAO {
    /**
     * 根据账号和密码获取特定用户信息
     * @param loginId
     * @param pwd
     * @return
     */
    @Override
    public UserBasic getUserBasic(String loginId, String pwd) {
        return super.load("SELECT * FROM `t_user_basic` WHERE `loginId` = ? AND `pwd` = ?", loginId, pwd);
    }

    /**目前的想法是，查到的fid直接赋值给basic生成新的UserBasic，但是问题是UserBasic没有fid这个属性，看看老师怎么办
     * 这里查到的全部都只有id
     * @param userBasic
     * @return
     */
    @Override
    public List<UserBasic> getUserBasicList(UserBasic userBasic) {
        String sql = "SELECT fid as 'id' FROM t_friend WHERE uid = ?";
        return super.executeQuery(sql,userBasic.getId());
    };

    @Override
    public UserBasic getUserBasicById(Integer id) {
        return load("SELECT * FROM `t_user_basic` WHERE `id` = ?", id);
    }


}
