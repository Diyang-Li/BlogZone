package com.atguigu.qqzone.controller;

import com.atguigu.qqzone.pojo.Topic;
import com.atguigu.qqzone.pojo.UserBasic;
import com.atguigu.qqzone.service.TopicService;
import com.atguigu.qqzone.service.UserBasicService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Diyang Li
 * @create 2022-04-26 9:05 AM
 */
public class UserController {
    private UserBasicService userBasicService= null;
    private TopicService topicService = null;

    /**
     * Login verfication 登录验证
     * @param loginId
     * @param pwd
     * @param session
     * @return
     */
    public String login(String loginId, String pwd, HttpSession session){
        UserBasic userBasic = userBasicService.login(loginId, pwd);
        if (userBasic!=null){
            List<UserBasic> friendList = userBasicService.getFriendList(userBasic);
            List<Topic> topicList = topicService.getTopicList(userBasic);

            userBasic.setFriendList(friendList);
            userBasic.setTopicList(topicList);

            //userBasic这个key保存的是登陆者的信息
            //friend这个key保存的是当前进入的是谁的空间，以后如果进入到好友的空间，要改动session：friend
            session.setAttribute("userBasic", userBasic);
            session.setAttribute("friend", userBasic);
            return "index";
        }
        return "login";
    }

    public String friend(Integer id, HttpSession session){
        UserBasic currentFriend = userBasicService.getUserBasicById(id);
        List<Topic> topicList = topicService.getTopicList(currentFriend);

        currentFriend.setTopicList(topicList);

        session.setAttribute("friend", currentFriend);

        return "index";
    }
}
