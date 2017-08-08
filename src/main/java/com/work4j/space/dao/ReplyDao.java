package com.work4j.space.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.work4j.space.pojo.Reply;
import com.work4j.space.pojo.form.ReplyForm;
import com.work4j.space.pojo.query.ReplyQuery;

/**
 * ReplyDao 
 */
public interface ReplyDao {
    
    /**
     * 查询 Reply
     */
    List<Reply> find(final ReplyQuery query);

    /**
     * 通过id得到一个 Reply
     */
    Reply get(final String id);
    
    /**
     * 新增 Reply
     */
    void add(final ReplyForm form);

    /**
     * 修改 Reply
     */
    int update(final ReplyForm form);
    
    /**
     * 删除一个 Reply
     */
    int delete(final String id);
    
    /**
     * 修改是否可用
     */
    int changeEnabled(@Param("id") final String id, @Param("enabled") final Integer enabled);
}