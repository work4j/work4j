package com.work4j.space.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.work4j.space.pojo.Reply;
import com.work4j.space.pojo.form.ReplyForm;
import com.work4j.space.pojo.query.ReplyQuery;
import com.work4j.space.dao.ReplyDao;
import com.work4j.space.service.ReplyService;


/**
 * ReplyService 
 */
@Service
public class ReplyServiceImpl implements ReplyService {
    @Autowired 
    private ReplyDao replyDao;
	
	/**
     * 查询 Reply
     */
    public List<Reply> find(final ReplyQuery query) {
        return replyDao.find(query);
    }
    
    /**
     * 分页查询 Reply
     */
    public Page<Reply> findByPage(final ReplyQuery query) {
        PageHelper.startPage(query.getPage().intValue(), query.getLimit().intValue());
        return (Page<Reply>) replyDao.find(query);
    }

    /**
     * 通过id得到一个 Reply
     */
    public Reply get(final String id) {
        return replyDao.get(id);
    }
    
    /**
     * 新增 Reply
     */
    public void add(final ReplyForm form) {
        replyDao.add(form);
    }

    /**
     * 修改 Reply
     */
    public int update(final ReplyForm form) {
        return replyDao.update(form);
    }
    
    /**
     * 删除一个 Reply
     */
    public int delete(final String id) {
        return replyDao.delete(id);
    }
	
	/**
     * 修改是否可用
     */
    public int changeEnabled(final String id, final Integer enabled) {
        return replyDao.changeEnabled(id, enabled);
    }
}