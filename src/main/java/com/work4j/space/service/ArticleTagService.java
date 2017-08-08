package com.work4j.space.service;

import java.util.List;
import com.github.pagehelper.Page;
import com.work4j.space.pojo.ArticleTag;
import com.work4j.space.pojo.form.ArticleTagForm;
import com.work4j.space.pojo.query.ArticleTagQuery;

/**
 * ArticleTagService 
 */
public interface ArticleTagService {

    /**
     * 查询 ArticleTag
     */
    List<ArticleTag> find(final ArticleTagQuery query);
    
    /**
     * 分页查询 ArticleTag
     */
    Page<ArticleTag> findByPage(final ArticleTagQuery query);

    /**
     * 通过id得到一个 ArticleTag
     */
    ArticleTag get(final String id);
    
    /**
     * 新增 ArticleTag
     */
    void add(final ArticleTagForm form);

    /**
     * 修改 ArticleTag
     */
    int update(final ArticleTagForm form);
    
    /**
     * 删除一个 ArticleTag
     */
    int delete(final String id);
	
	/**
     * 修改是否可用
     */
    int changeEnabled(final String id, final Integer enabled);
}