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
    private java.util.Date replyTime; // replyTime
    private java.util.Date createDataTime; // createDataTime
    private String createDataUsername; // createDataUsername
    private java.util.Date updateDataTime; // updateDataTime
    private String updateDataUsername; // updateDataUsername
    private Integer enabled; // enabled
}