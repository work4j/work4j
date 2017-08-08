package com.work4j.space.pojo.query;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ArticleTagQuery 
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ArticleTagQuery implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String id; // id
    private String articleId; // articleId
    private String tagId; // tagId
	
    private Integer page = 1;
    private Integer limit = 20;
    private String search;
}