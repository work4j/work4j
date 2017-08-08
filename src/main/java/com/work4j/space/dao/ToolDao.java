package com.work4j.space.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.work4j.space.pojo.Tool;
import com.work4j.space.pojo.form.ToolForm;
import com.work4j.space.pojo.query.ToolQuery;

/**
 * ToolDao 
 */
public interface ToolDao {
    
    /**
     * 查询 Tool
     */
    List<Tool> find(final ToolQuery query);

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
    int changeEnabled(@Param("id") final String id, @Param("enabled") final Integer enabled);
}