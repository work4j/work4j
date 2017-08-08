package com.work4j.space.pojo.query;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ArticleQuery 
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ArticleQuery implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String id; // id
    private String title; // title
    private String content; // content
    private String userId; // userId
    private java.util.Date releaseTime; // releaseTime
    private Integer seeNum; // seeNum
    private Integer replyNum; // replyNum
    private String htmlContent; // htmlContent
    private Integer enabled; // enabled
    private java.util.Date createDataTime; // createDataTime
    private String createDataUsername; // createDataUsername
    private java.util.Date updateDataTime; // updateDataTime
    private String updateDataUsername; // updateDataUsername
	
    private Integer page = 1;
    private Integer limit = 20;
    private String search;
}