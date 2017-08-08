package com.work4j.space.service;

import java.util.List;
import com.github.pagehelper.Page;
import com.work4j.space.pojo.Reply;
import com.work4j.space.pojo.form.ReplyForm;
import com.work4j.space.pojo.query.ReplyQuery;

/**
 * ReplyService 
 */
public interface ReplyService {

    /**
     * 查询 Reply
     */
    List<Reply> find(final ReplyQuery query);
    
    /**
     * 分页查询 Reply
     */
    Page<Reply> findByPage(final ReplyQuery query);

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
    int changeEnabled(final String id, final Integer enabled);
}