package com.atguigu.qqzone.pojo;

import java.util.Date;
import java.util.List;

/**
 * @author Diyang Li
 * @create 2022-04-21 12:11 PM
 */
public class Topic {
    private Integer id;
    private String title;
    private String content;
    // 这里mysql之前的topicDate是datetime，会报错java.util.Date, java.sql.Date, java.time.LocalDate
    //解决办法是：
    //LocalDateTime解决：将pojo中的topicDate数据类型改成LocalDateTime，MySql版本问题,
    // 8.0的datetime类型对应jdk8的LocalDateTime。
    //或者
    //将MySQL中topicDate类型改为Date类型（我目前采用的办法）
    private Date topicDate;
    private UserBasic author;          //M:1

    private List<Reply> replyList;     //1:N

    public Topic() {
    }

    public Topic(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTopicDate() {
        return topicDate;
    }

    public void setTopicDate(Date topicDate) {
        this.topicDate = topicDate;
    }

    public UserBasic getAuthor() {
        return author;
    }

    public void setAuthor(UserBasic author) {
        this.author = author;
    }

    public List<Reply> getReplyList() {
        return replyList;
    }

    public void setReplyList(List<Reply> replyList) {
        this.replyList = replyList;
    }
}
