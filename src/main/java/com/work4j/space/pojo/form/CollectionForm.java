package com.work4j.space.pojo.form;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.UUID;

/**
 * CollectionForm 
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CollectionForm implements Serializable {
    private static final long serialVersionUID = 1L;
    
	private String id = UUID.randomUUID().toString().replaceAll("-", "");
	private String userId; // userId
	private String articleId; // articleId
	private Date collectionTime = new Date(); //collectionTime
}