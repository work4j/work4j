package com.work4j.space.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.work4j.space.pojo.Tag;
import com.work4j.space.pojo.form.TagForm;
import com.work4j.space.pojo.query.TagQuery;
import com.work4j.space.dao.TagDao;
import com.work4j.space.service.TagService;


/**
 * TagService 
 */
@Service
public class TagServiceImpl implements TagService {
    @Autowired 
    private TagDao tagDao;
	
	/**
     * 查询 Tag
     */
    public List<Tag> find(final TagQuery query) {
        return tagDao.find(query);
    }
    
    /**
     * 分页查询 Tag
     */
    public Page<Tag> findByPage(final TagQuery query) {
        PageHelper.startPage(query.getPage().intValue(), query.getLimit().intValue());
        return (Page<Tag>) tagDao.find(query);
    }

    /**
     * 通过id得到一个 Tag
     */
    public Tag get(final String id) {
        return tagDao.get(id);
    }
    
    /**
     * 新增 Tag
     */
    public void add(final TagForm form) {
        tagDao.add(form);
    }

    /**
     * 修改 Tag
     */
    public int update(final TagForm form) {
        return tagDao.update(form);
    }
    
    /**
     * 删除一个 Tag
     */
    public int delete(final String id) {
        return tagDao.delete(id);
    }
	
	/**
     * 修改是否可用
     */
    public int changeEnabled(final String id, final Integer enabled) {
        return tagDao.changeEnabled(id, enabled);
    }
}