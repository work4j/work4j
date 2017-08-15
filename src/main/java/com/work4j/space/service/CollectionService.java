package com.work4j.space.service;

import java.util.List;
import com.github.pagehelper.Page;
import com.work4j.space.pojo.Collection;
import com.work4j.space.pojo.form.CollectionForm;
import com.work4j.space.pojo.query.CollectionQuery;

/**
 * CollectionService 
 */
public interface CollectionService {

    /**
     * 查询 Collection
     */
    List<Collection> find(final CollectionQuery query);
    
    /**
     * 分页查询 Collection
     */
    Page<Collection> findByPage(final CollectionQuery query);

    /**
     * 通过id得到一个 Collection
     */
    Collection get(final String id);
    
    /**
     * 新增 Collection
     */
    void add(final CollectionForm form);

    /**
     * 修改 Collection
     */
    int update(final CollectionForm form);
    
    /**
     * 删除一个 Collection
     */
    int delete(final String id);

    /**
     * 删除一个 Collection
     */
    public int delete(final CollectionQuery query);
	
	/**
     * 修改是否可用
     */
    int changeEnabled(final String id, final Integer enabled);
}