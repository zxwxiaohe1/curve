package com.curve.core;

import com.curve.core.init.SpringContextHolder;
import com.curve.core.utils.ConstantUtil;
import com.curve.modules.comm.dao.MemoryTaskDao;
import com.curve.modules.comm.entity.MemoryTask;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.List;
import java.util.Properties;

/**
 * @author: Created by heyong.
 * @createtime: on 2018/8/19.
 * @copyright&copy: <a href="http://www.sinux.com.cn">JFusion</a> All rights reserved
 */
@Intercepts({ @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})})
public class SQLInterceptor implements Interceptor {

    private MemoryTaskDao memoryTaskDao;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        final MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        Object parameter = invocation.getArgs()[1];
        BoundSql boundSql = mappedStatement.getBoundSql(parameter);
        if (boundSql.getSql().contains("memory_task")) {
            memoryTaskDao  = SpringContextHolder.getBean(MemoryTaskDao.class);
            List<MemoryTask> memoryTasks = memoryTaskDao.findTop10ByNoticeDate(new MemoryTask());
            if (memoryTasks.size()>0) {
                ConstantUtil.memoryTasks.clear();
                for (MemoryTask memoryTask : memoryTasks) {
                    ConstantUtil.memoryTasks.offer(memoryTask);
                }
            }
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
    }

}
