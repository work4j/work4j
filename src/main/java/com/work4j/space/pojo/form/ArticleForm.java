package com.work4j.space.pojo.form;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.UUID;

/**
 * ArticleForm 
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ArticleForm implements Serializable {
    private static final long serialVersionUID = 1L;
    
	private String id = UUID.randomUUID().toString().replaceAll("-", "");
	private String title; // title
	private String content; // content
	private String userId; // userId
	private java.util.Date releaseTime = new Date(); // releaseTime
	private Integer seeNum = 0; // seeNum
	private String columnId; // columnId
	private Integer enabled = 1; // enabled
	private java.util.Date createDataTime = new Date(); // createDataTime
	private String createDataUsername; // createDataUsername
	private java.util.Date updateDataTime; // updateDataTime
	private String updateDataUsername; // updateDataUsername

	private String tags; //标签
}