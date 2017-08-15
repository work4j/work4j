package com.work4j.space.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * Reply 
 */
@Data
public class Reply implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String id; // id
    private String userId; // userId
    private String articleId; // articleId
    private String content; // content
    private String toReplyId; // toReplyId
    private java.util.Date replyTime; // replyTime
    private java.util.Date createDataTime; // createDataTime
    private String createDataUsername; // createDataUsername
    private java.util.Date updateDataTime; // updateDataTime
    private String updateDataUsername; // updateDataUsername
    private Integer enabled; // enabled

    private String nickname; //nickname
    private Reply toReply; //toReply
    private String title; //title
}