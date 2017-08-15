package com.work4j.space.pojo.query;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * CollectionQuery 
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CollectionQuery implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String id; // id
    private String userId; // userId
    private String articleId; // articleId
    private Date collectionTime; //collectionTime
	
    private Integer page = 1;
    private Integer limit = 20;
    private String simpleQueryParam;
}