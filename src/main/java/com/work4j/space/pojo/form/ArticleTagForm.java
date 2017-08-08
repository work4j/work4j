package com.work4j.space.pojo.form;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.UUID;

/**
 * ArticleTagForm 
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ArticleTagForm implements Serializable {
    private static final long serialVersionUID = 1L;
    
	private String id = UUID.randomUUID().toString().replaceAll("-", "");
	private String articleId; // articleId
	private String tagId; // tagId
}