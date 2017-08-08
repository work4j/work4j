package com.work4j.space.service;

import java.util.List;
import com.github.pagehelper.Page;
import com.work4j.space.pojo.Column;
import com.work4j.space.pojo.form.ColumnForm;
import com.work4j.space.pojo.query.ColumnQuery;

/**
 * ColumnService 
 */
public interface ColumnService {

    /**
     * 查询 Column
     */
    List<Column> find(final ColumnQuery query);
    
    /**
     * 分页查询 Column
     */
    Page<Column> findByPage(final ColumnQuery query);

    /**
     * 通过id得到一个 Column
     */
    Column get(final String id);
    
    /**
     * 新增 Column
     */
    void add(final ColumnForm form);

    /**
     * 修改 Column
     */
    int update(final ColumnForm form);
    
    /**
     * 删除一个 Column
     */
    int delete(final String id);
	
	/**
     * 修改是否可用
     */
    int changeEnabled(final String id, final Integer enabled);
}