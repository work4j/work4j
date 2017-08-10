package com.work4j.space.service;

import java.util.List;
import com.github.pagehelper.Page;
import com.work4j.space.pojo.Article;
import com.work4j.space.pojo.form.ArticleForm;
import com.work4j.space.pojo.query.ArticleQuery;

/**
 * ArticleService 
 */
public interface ArticleService {

    /**
     * 查询 Article
     */
    List<Article> find(final ArticleQuery query);
    
    /**
     * 分页查询 Article
     */
    Page<Article> findByPage(final ArticleQuery query);

    /**
     * 通过id得到一个 Article
     */
    Article get(final String id);
    
    /**
     * 新增 Article
     */
    void add(final ArticleForm form);

    /**
     * 修改 Article
     */
    int update(final ArticleForm form);
    
    /**
     * 删除一个 Article
     */
    int delete(final String id);
	
	/**
     * 修改是否可用
     */
    int changeEnabled(final String id, final Integer enabled);

    /**
     * 修改 seeNum
     */
    int updateSeeNum(final String id);
}