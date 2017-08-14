package com.work4j.space.pojo;

import java.io.Serializable;
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

    private String title; // title
}