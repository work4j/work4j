package com.work4j.space.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.work4j.space.pojo.ArticleTag;
import com.work4j.space.pojo.form.ArticleTagForm;
import com.work4j.space.pojo.query.ArticleTagQuery;

/**
 * ArticleTagDao 
 */
public interface ArticleTagDao {
    
    /**
     * 查询 ArticleTag
     */
    List<ArticleTag> find(final ArticleTagQuery query);

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
     * 删除 ArticleTag
     */
    int deleteByArticleId(@Param("articleId") final String articleId);

    /**
     * 删除 ArticleTag
     */
    int deleteByTagId(@Param("tagId") final String tagId);

    /**
     * 修改是否可用
     */
    int changeEnabled(@Param("id") final String id, @Param("enabled") final Integer enabled);
}