package com.work4j.space.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.work4j.space.pojo.Article;
import com.work4j.space.pojo.form.ArticleForm;
import com.work4j.space.pojo.query.ArticleQuery;
import com.work4j.space.dao.ArticleDao;
import com.work4j.space.service.ArticleService;


/**
 * ArticleService 
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired 
    private ArticleDao articleDao;
	
	/**
     * 查询 Article
     */
    public List<Article> find(final ArticleQuery query) {
        return articleDao.find(query);
    }
    
    /**
     * 分页查询 Article
     */
    public Page<Article> findByPage(final ArticleQuery query) {
        PageHelper.startPage(query.getPage().intValue(), query.getLimit().intValue());
        return (Page<Article>) articleDao.find(query);
    }

    /**
     * 通过id得到一个 Article
     */
    public Article get(final String id) {
        return articleDao.get(id);
    }
    
    /**
     * 新增 Article
     */
    public void add(final ArticleForm form) {
        articleDao.add(form);
    }

    /**
     * 修改 Article
     */
    public int update(final ArticleForm form) {
        return articleDao.update(form);
    }
    
    /**
     * 删除一个 Article
     */
    public int delete(final String id) {
        return articleDao.delete(id);
    }
	
	/**
     * 修改是否可用
     */
    public int changeEnabled(final String id, final Integer enabled) {
        return articleDao.changeEnabled(id, enabled);
    }
}