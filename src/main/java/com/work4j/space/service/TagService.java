package com.work4j.space.service;

import java.util.List;
import com.github.pagehelper.Page;
import com.work4j.space.pojo.Tag;
import com.work4j.space.pojo.form.TagForm;
import com.work4j.space.pojo.query.TagQuery;

/**
 * TagService 
 */
public interface TagService {

    /**
     * 查询 Tag
     */
    List<Tag> find(final TagQuery query);
    
    /**
     * 分页查询 Tag
     */
    Page<Tag> findByPage(final TagQuery query);

    /**
     * 通过id得到一个 Tag
     */
    Tag get(final String id);
    
    /**
     * 新增 Tag
     */
    void add(final TagForm form);

    /**
     * 修改 Tag
     */
    int update(final TagForm form);
    
    /**
     * 删除一个 Tag
     */
    int delete(final String id);
	
	/**
     * 修改是否可用
     */
    int changeEnabled(final String id, final Integer enabled);
}