package com.curve.modules.comm.service;

import com.curve.modules.comm.dao.UserDao;
import com.curve.modules.comm.entity.User;
import org.springframework.stereotype.Service;


/**
 * @author: Created by heyong.
 * @createtime: on 2018/8/17.
 * @copyright&copy: <a href="http://www.sinux.com.cn">JFusion</a> All rights reserved
 */
@Service
public class UserService extends BaseService<UserDao,User> {

    /**
     * 根据登录名获取单条数据
     * @param user User
     * @return User
     */
    public User getByLoginName(User user){
        return dao.getByLoginName(user);
    }
    /**
     * 根据登录名获取单条数据
     * @param user User
     * @return User
     */
    public User login(User user){
        return dao.getByLoginNameAndPassword(user);
    }
}
