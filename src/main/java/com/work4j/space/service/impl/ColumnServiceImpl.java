package com.work4j.space.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.work4j.space.pojo.Column;
import com.work4j.space.pojo.form.ColumnForm;
import com.work4j.space.pojo.query.ColumnQuery;
import com.work4j.space.dao.ColumnDao;
import com.work4j.space.service.ColumnService;


/**
 * ColumnService 
 */
@Service
public class ColumnServiceImpl implements ColumnService {
    @Autowired 
    private ColumnDao columnDao;
	
	/**
     * 查询 Column
     */
    public List<Column> find(final ColumnQuery query) {
        return columnDao.find(query);
    }
    
    /**
     * 分页查询 Column
     */
    public Page<Column> findByPage(final ColumnQuery query) {
        PageHelper.startPage(query.getPage().intValue(), query.getLimit().intValue());
        return (Page<Column>) columnDao.find(query);
    }

    /**
     * 通过id得到一个 Column
     */
    public Column get(final String id) {
        return columnDao.get(id);
    }
    
    /**
     * 新增 Column
     */
    public void add(final ColumnForm form) {
        columnDao.add(form);
    }

    /**
     * 修改 Column
     */
    public int update(final ColumnForm form) {
        return columnDao.update(form);
    }
    
    /**
     * 删除一个 Column
     */
    public int delete(final String id) {
        return columnDao.delete(id);
    }
	
	/**
     * 修改是否可用
     */
    public int changeEnabled(final String id, final Integer enabled) {
        return columnDao.changeEnabled(id, enabled);
    }
}