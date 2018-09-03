package com.curve.modules.comm.dao;

import com.curve.modules.comm.entity.MemoryTask;
import com.curve.modules.comm.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Created by heyong.
 * @createtime: on 2018/8/3.
 */
@Repository
public interface UserDao extends BaseDao<User> {

    /**
     * 根据登录名获取单条数据
     * @param user User
     * @return User
     */
    public User getByLoginName(User user);
    /**
     * 根据登录名获取单条数据
     * @param user User
     * @return User
     */
    public User getByLoginNameAndPassword(User user);
    /**
     * 根据记忆任务查询任务所属人
     * @param memoryTask MemoryTask
     * @return User
     */
    public User findUserByMemoryTask(MemoryTask memoryTask);
    /**
     * 记录记忆任务与用户的关联关系
     * @param memoryTask MemoryTask
     * @return Integer
     */
    public Integer insetUserMemoryTaskConn(MemoryTask memoryTask);
    /**
     * 获得所有需要特定时间段通知的用户
     * @param memoryTask MemoryTask
     * @return Integer
     */
    public List<User> findUsersNoticeSpecial(User User);
}
