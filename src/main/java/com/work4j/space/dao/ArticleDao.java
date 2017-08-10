package com.work4j.space.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.work4j.space.pojo.Article;
import com.work4j.space.pojo.form.ArticleForm;
import com.work4j.space.pojo.query.ArticleQuery;

/**
 * ArticleDao 
 */
public interface ArticleDao {
    
    /**
     * 查询 Article
     */
    List<Article> find(final ArticleQuery query);

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
    int changeEnabled(@Param("id") final String id, @Param("enabled") final Integer enabled);

    /**
     * 修改seeNum
     */
    int updateSeeNum(final String id);
}