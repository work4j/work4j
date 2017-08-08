package com.work4j.space.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * ArticleTag 
 */
@Data
public class ArticleTag implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String id; // id
    private String articleId; // articleId
    private String tagId; // tagId
}