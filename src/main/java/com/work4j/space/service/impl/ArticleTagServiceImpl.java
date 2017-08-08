package com.work4j.space.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.work4j.space.pojo.ArticleTag;
import com.work4j.space.pojo.form.ArticleTagForm;
import com.work4j.space.pojo.query.ArticleTagQuery;
import com.work4j.space.dao.ArticleTagDao;
import com.work4j.space.service.ArticleTagService;


/**
 * ArticleTagService 
 */
@Service
public class ArticleTagServiceImpl implements ArticleTagService {
    @Autowired 
    private ArticleTagDao articleTagDao;
	
	/**
     * 查询 ArticleTag
     */
    public List<ArticleTag> find(final ArticleTagQuery query) {
        return articleTagDao.find(query);
    }
    
    /**
     * 分页查询 ArticleTag
     */
    public Page<ArticleTag> findByPage(final ArticleTagQuery query) {
        PageHelper.startPage(query.getPage().intValue(), query.getLimit().intValue());
        return (Page<ArticleTag>) articleTagDao.find(query);
    }

    /**
     * 通过id得到一个 ArticleTag
     */
    public ArticleTag get(final String id) {
        return articleTagDao.get(id);
    }
    
    /**
     * 新增 ArticleTag
     */
    public void add(final ArticleTagForm form) {
        articleTagDao.add(form);
    }

    /**
     * 修改 ArticleTag
     */
    public int update(final ArticleTagForm form) {
        return articleTagDao.update(form);
    }
    
    /**
     * 删除一个 ArticleTag
     */
    public int delete(final String id) {
        return articleTagDao.delete(id);
    }
	
	/**
     * 修改是否可用
     */
    public int changeEnabled(final String id, final Integer enabled) {
        return articleTagDao.changeEnabled(id, enabled);
    }
}