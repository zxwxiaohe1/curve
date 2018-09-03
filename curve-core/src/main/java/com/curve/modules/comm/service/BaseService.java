/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.curve.modules.comm.service;

import com.curve.modules.comm.dao.BaseDao;
import com.curve.modules.comm.entity.BaseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Entity支持类
 * @author heyong
 * @version 2018-05-16
 */
public abstract class BaseService<D extends BaseDao<T>, T extends BaseEntity<T>> {

    @Autowired
    protected D dao;

    protected Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 单条获取
     * @return Integer
     */
    public T get(T t){
        return dao.get(t);
    }
    /**
     * 单条插入或修改
     * @return Integer
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer save(T t) {
        int result;
        if (null == dao.get(t)) {
            t.preInsert();
            result = dao.insert(t);
        } else {
            t.preUpdate();
            result = dao.update(t);
        }
        return result;
    }
    /**
     * 单条删除
     * @return Integer
     */
    public Integer delete(T t){
        return dao.delete(t);
    }
}
