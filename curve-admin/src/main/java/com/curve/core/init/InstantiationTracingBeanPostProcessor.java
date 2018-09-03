package com.curve.core.init;

import com.curve.core.opt.MemoryTaskNoticeInit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @author: Created by heyong.
 * @createtime: on 2018/8/19.
 * @copyright&copy: <a href="http://www.sinux.com.cn">JFusion</a> All rights reserved
 */
public class InstantiationTracingBeanPostProcessor implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //root application context 没有parent，他就是老大.
        if(contextRefreshedEvent.getApplicationContext().getParent() == null){
            ApplicationContext apc = contextRefreshedEvent.getApplicationContext();
            MemoryTaskNoticeInit memoryTask = new MemoryTaskNoticeInit();
            memoryTask.createNoticeTask();
        }
    }
}
