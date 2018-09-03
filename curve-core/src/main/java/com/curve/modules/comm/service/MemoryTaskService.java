package com.curve.modules.comm.service;

import com.curve.modules.comm.dao.MemoryTaskDao;
import com.curve.modules.comm.dao.UserDao;
import com.curve.modules.comm.entity.MemoryTask;
import com.curve.modules.comm.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author: Created by heyong.
 * @createtime: on 2018/8/17.
 * @copyright&copy: <a href="http://www.sinux.com.cn">JFusion</a> All rights reserved
 */
@Service
public class MemoryTaskService extends BaseService<MemoryTaskDao,MemoryTask> {

    @Autowired
    private UserDao userDao;
    /**
     * 单条插入或修改
     * @return Integer
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer save(MemoryTask memoryTask) {
        memoryTask.preInsert();
        User user=new User();
        user.setId("1");
        memoryTask.setUser(user);
        userDao.insetUserMemoryTaskConn(memoryTask);
        return dao.insert(memoryTask);
    }
}
