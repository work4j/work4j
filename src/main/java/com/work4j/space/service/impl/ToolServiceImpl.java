package com.work4j.space.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.work4j.space.pojo.Tool;
import com.work4j.space.pojo.form.ToolForm;
import com.work4j.space.pojo.query.ToolQuery;
import com.work4j.space.dao.ToolDao;
import com.work4j.space.service.ToolService;


/**
 * ToolService 
 */
@Service
public class ToolServiceImpl implements ToolService {
    @Autowired 
    private ToolDao toolDao;
	
	/**
     * 查询 Tool
     */
    public List<Tool> find(final ToolQuery query) {
        return toolDao.find(query);
    }
    
    /**
     * 分页查询 Tool
     */
    public Page<Tool> findByPage(final ToolQuery query) {
        PageHelper.startPage(query.getPage().intValue(), query.getLimit().intValue());
        return (Page<Tool>) toolDao.find(query);
    }

    /**
     * 通过id得到一个 Tool
     */
    public Tool get(final String id) {
        return toolDao.get(id);
    }
    
    /**
     * 新增 Tool
     */
    public void add(final ToolForm form) {
        toolDao.add(form);
    }

    /**
     * 修改 Tool
     */
    public int update(final ToolForm form) {
        return toolDao.update(form);
    }
    
    /**
     * 删除一个 Tool
     */
    public int delete(final String id) {
        return toolDao.delete(id);
    }
	
	/**
     * 修改是否可用
     */
    public int changeEnabled(final String id, final Integer enabled) {
        return toolDao.changeEnabled(id, enabled);
    }
}