package com.work4j.space.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * Collection 
 */
@Data
public class Collection implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String id; // id
    private String userId; // userId
    private String articleId; // articleId
    private Date collectionTime; //collectionTime

    private String title; // title
}