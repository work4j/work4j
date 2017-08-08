package com.work4j.space.service;

import java.util.List;
import com.github.pagehelper.Page;
import com.work4j.space.pojo.Tool;
import com.work4j.space.pojo.form.ToolForm;
import com.work4j.space.pojo.query.ToolQuery;

/**
 * ToolService 
 */
public interface ToolService {

    /**
     * 查询 Tool
     */
    List<Tool> find(final ToolQuery query);
    
    /**
     * 分页查询 Tool
     */
    Page<Tool> findByPage(final ToolQuery query);

    /**
     * 通过id得到一个 Tool
     */
    Tool get(final String id);
    
    /**
     * 新增 Tool
     */
    void add(final ToolForm form);

    /**
     * 修改 Tool
     */
    int update(final ToolForm form);
    
    /**
     * 删除一个 Tool
     */
    int delete(final String id);
	
	/**
     * 修改是否可用
     */
    int changeEnabled(final String id, final Integer enabled);
}