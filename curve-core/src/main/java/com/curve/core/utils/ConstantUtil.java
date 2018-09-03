package com.curve.core.utils;

import com.curve.modules.comm.entity.MemoryTask;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author: Created by heyong.
 * @createtime: on 2018/8/19.
 * @copyright&copy: <a href="http://www.sinux.com.cn">JFusion</a> All rights reserved
 */
public class ConstantUtil {
    public static final String YES = "1";
    public static final String NO = "0";
    public static BlockingQueue<MemoryTask> memoryTasks = new LinkedBlockingQueue<>(10);
    public static final String TASK_NOTICE_LINK = "0:1,0:2,0:4,0:7,0:15,0:30";
}
