package com.work4j.space.service.impl;

import com.work4j.space.common.SystemHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.work4j.space.pojo.Collection;
import com.work4j.space.pojo.form.CollectionForm;
import com.work4j.space.pojo.query.CollectionQuery;
import com.work4j.space.dao.CollectionDao;
import com.work4j.space.service.CollectionService;


/**
 * CollectionService 
 */
@Service
public class CollectionServiceImpl implements CollectionService {
    @Autowired 
    private CollectionDao collectionDao;
	
	/**
     * 查询 Collection
     */
    public List<Collection> find(final CollectionQuery query) {
        return collectionDao.find(query);
    }
    
    /**
     * 分页查询 Collection
     */
    public Page<Collection> findByPage(final CollectionQuery query) {
        PageHelper.startPage(query.getPage().intValue(), query.getLimit().intValue());
        return (Page<Collection>) collectionDao.find(query);
    }

    /**
     * 通过id得到一个 Collection
     */
    public Collection get(final String id) {
        return collectionDao.get(id);
    }
    
    /**
     * 新增 Collection
     */
    public void add(final CollectionForm form) {
        collectionDao.add(form);
    }

    /**
     * 修改 Collection
     */
    public int update(final CollectionForm form) {
        return collectionDao.update(form);
    }
    
    /**
     * 删除一个 Collection
     */
    public int delete(final String id) {
        return collectionDao.delete(id);
    }

    /**
     * 删除一个 Collection
     */
    public int delete(final CollectionQuery query) {
        return collectionDao.deleteByQuery(query);
    }

	/**
     * 修改是否可用
     */
    public int changeEnabled(final String id, final Integer enabled) {
        return collectionDao.changeEnabled(id, enabled);
    }
}