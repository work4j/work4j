package com.work4j.space.service;

import java.util.List;
import com.github.pagehelper.Page;
import com.work4j.space.pojo.User;
import com.work4j.space.pojo.form.UserForm;
import com.work4j.space.pojo.query.UserQuery;

/**
 * UserService 
 */
public interface UserService {

    /**
     * 查询 User
     */
    List<User> find(final UserQuery query);
    
    /**
     * 分页查询 User
     */
    Page<User> findByPage(final UserQuery query);

    /**
     * 通过id得到一个 User
     */
    User get(final String id);
    
    /**
     * 新增 User
     */
    void add(final UserForm form);

    /**
     * 修改 User
     */
    int update(final UserForm form);
    
    /**
     * 删除一个 User
     */
    int delete(final String id);
	
	/**
     * 修改是否可用
     */
    int changeEnabled(final String id, final Integer enabled);
}