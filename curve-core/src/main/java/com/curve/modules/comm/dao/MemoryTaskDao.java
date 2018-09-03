package com.curve.modules.comm.dao;

import com.curve.modules.comm.entity.MemoryTask;
import com.curve.modules.comm.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Created by heyong.
 * @createtime: on 2018/8/19.
 * @copyright&copy: <a href="http://www.sinux.com.cn">JFusion</a> All rights reserved
 */
@Repository
public interface MemoryTaskDao extends BaseDao<MemoryTask> {
    public MemoryTask findMinByNoticeDate(MemoryTask memoryTask);
    public List<MemoryTask> findTop10ByNoticeDate(MemoryTask memoryTask);
//    public List<MemoryTask> findCurrentNoticeTask(MemoryTask memoryTask);
    public Integer insetNoticedTask(MemoryTask memoryTask);
    public List<MemoryTask> findNoticedTask(MemoryTask memoryTask);
    public Integer deleteNoticedTask(MemoryTask memoryTask);
}
