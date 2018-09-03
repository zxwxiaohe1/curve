package com.curve.modules.comm.web;

import com.curve.core.dto.Result;
import com.curve.core.utils.ConstantUtil;
import com.curve.core.utils.StringUtils;
import com.curve.modules.comm.entity.MemoryTask;
import com.curve.modules.comm.entity.User;
import com.curve.modules.comm.service.MemoryTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author: Created by heyong.
 * @createtime: on 2018/8/19.
 * @copyright&copy: <a href="http://www.sinux.com.cn">JFusion</a> All rights reserved
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "rest/sys/task")
public class TaskController extends BaseController {

    @Autowired
    private MemoryTaskService memoryTaskService;
    /**
     * 保存任务信息
     *
     * @param task MemoryTask
     * @return Result<?>
     */
    @RequestMapping(value = "/save", method = {RequestMethod.POST, RequestMethod.PUT})
    public Result<?> save(@RequestBody MemoryTask task) {
        if (null != task) {
            if (StringUtils.isBlank(task.getLink())) {
                task.setLink(ConstantUtil.TASK_NOTICE_LINK);
            }
            if (ConstantUtil.YES.equals(task.getTodo())) {
                task.updateNoticeDate();
            }
            if (memoryTaskService.save(task) > 0) {
                return success("任务保存成功!");
            } else {
                return error("任务保存失败!");
            }
        }
        return error("任务保存失败!");
    }
}
