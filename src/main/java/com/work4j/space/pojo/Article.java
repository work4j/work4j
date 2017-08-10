package com.work4j.space.pojo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * Article 
 */
@Data
public class Article implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String id; // id
    private String title; // title
    private String content; // content
    private String userId; // userId
    private java.util.Date releaseTime; // releaseTime
    private Integer seeNum; // seeNum
    private Integer replyNum; // replyNum
    private String columnId; // columnId
    private Integer enabled; // enabled
    private java.util.Date createDataTime; // createDataTime
    private String createDataUsername; // createDataUsername
    private java.util.Date updateDataTime; // updateDataTime
    private String updateDataUsername; // updateDataUsername

    private String nickname; // 用户昵称
    private List<Tag> tags; //标签
}