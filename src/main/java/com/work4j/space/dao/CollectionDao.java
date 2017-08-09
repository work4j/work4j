package com.work4j.space.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.work4j.space.pojo.Collection;
import com.work4j.space.pojo.form.CollectionForm;
import com.work4j.space.pojo.query.CollectionQuery;

/**
 * CollectionDao 
 */
public interface CollectionDao {
    
    /**
     * 查询 Collection
     */
    List<Collection> find(final CollectionQuery query);

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
     * 修改是否可用
     */
    int changeEnabled(@Param("id") final String id, @Param("enabled") final Integer enabled);
}