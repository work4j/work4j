package com.work4j.space.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.work4j.space.pojo.Tag;
import com.work4j.space.pojo.form.TagForm;
import com.work4j.space.pojo.query.TagQuery;

/**
 * TagDao 
 */
public interface TagDao {
    
    /**
     * 查询 Tag
     */
    List<Tag> find(final TagQuery query);

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
    int changeEnabled(@Param("id") final String id, @Param("enabled") final Integer enabled);
}