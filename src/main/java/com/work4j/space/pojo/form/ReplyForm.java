package com.work4j.space.pojo.form;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.UUID;
/**
 * ReplyForm 
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ReplyForm implements Serializable {
    private static final long serialVersionUID = 1L;
    
	private String id = UUID.randomUUID().toString().replaceAll("-", "");
	private String userId; // userId
	private String articleId; // articleId
	private String content; // content
	private String toReplyId; // toReplyId
	private java.util.Date replyTime = new Date(); // replyTime
	private java.util.Date createDataTime = new Date(); // createDataTime
	private String createDataUsername; // createDataUsername
	private java.util.Date updateDataTime; // updateDataTime
	private String updateDataUsername; // updateDataUsername
	private Integer enabled = 1; // enabled
}