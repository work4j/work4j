package com.work4j.space.pojo.query;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;

/**
 * ReplyQuery 
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ReplyQuery implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String id; // id
    private String userId; // userId
    private String articleId; // articleId
    private String content; // content
    private java.util.Date replyTime; // replyTime
    private java.util.Date createDataTime; // createDataTime
    private String createDataUsername; // createDataUsername
    private java.util.Date updateDataTime = new Date(); // updateDataTime
    private String updateDataUsername; // updateDataUsername
    private Integer enabled; // enabled
	
    private Integer page = 1;
    private Integer limit = 20;
    private String search;
}