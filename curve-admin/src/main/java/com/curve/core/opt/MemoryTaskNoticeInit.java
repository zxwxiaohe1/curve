package com.curve.core.opt;

import com.curve.core.Loader.PropertiesLoader;
import com.curve.core.init.SpringContextHolder;
import com.curve.core.mail.MailSendUtils;
import com.curve.core.utils.ConstantUtil;
import com.curve.modules.comm.dao.MemoryTaskDao;
import com.curve.modules.comm.dao.SystemConfigDao;
import com.curve.modules.comm.dao.UserDao;
import com.curve.modules.comm.entity.MemoryTask;
import com.curve.modules.comm.entity.SystemConfig;
import com.curve.modules.comm.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author: Created by heyong.
 * @createtime: on 2018/8/19.
 * @copyright&copy: <a href="http://www.sinux.com.cn">JFusion</a> All rights reserved
 */
public class MemoryTaskNoticeInit {

    private static MemoryTaskDao memoryTaskDao = SpringContextHolder.getBean(MemoryTaskDao.class);
    private static SystemConfigDao systemConfigDao = SpringContextHolder.getBean(SystemConfigDao.class);
    private static UserDao userDao = SpringContextHolder.getBean(UserDao.class);
    private static Logger logger = LoggerFactory.getLogger(MemoryTaskNoticeInit.class);

    public MemoryTaskNoticeInit() {
    }

    public void createNoticeTask() {
        new Thread(new Runnable(){
            @Override
            public void run(){
                doTask();
            }
        }).start();
    }

    public void doTask() {
        SystemConfig systemConfig = systemConfigDao.get(new SystemConfig("1"));
        while (true) {
            MemoryTask currTask = ConstantUtil.memoryTasks.peek();
            Date now = new Date();
            if (null != currTask) {
                if (now.compareTo(currTask.getNoticeDate()) >= 0) {
                    User user = userDao.findUserByMemoryTask(currTask);
                    if (null != user) {
                        //发送密钥信息到用户邮箱
                        boolean send = MailSendUtils.sendEmail(systemConfig.getSmtp(), systemConfig.getPort(), systemConfig.getMailName(),
                                systemConfig.getMailPassword(), user.getEmail(), currTask.getTitle(), currTask.getContent(), "1");
                        if (send) {
                            memoryTaskDao.insetNoticedTask(currTask);
                            logger.debug("已发送");
                        }
                        if (currTask.updateLink()) {
                            currTask.updateNoticeDate();
                        }
                        if (currTask.isDoFanish()) {
                            memoryTaskDao.deleteNoticedTask(currTask);
                            currTask.setDelFlag("1");
                        }
                        currTask.setUpdateDate(new Date());
                        memoryTaskDao.update(currTask);
                        ConstantUtil.memoryTasks.remove();
                        currTask = null;

                    }
                } else {
                    logger.debug("当前"+currTask.getTitle()+"还没到通知时间，再睡会儿！");
                }
            } else {
                logger.debug("哎呀!通知任务没得了,快点补充一点,不然要挨打");
                List<MemoryTask> memoryTasks = memoryTaskDao.findTop10ByNoticeDate(new MemoryTask());
                if (memoryTasks.size()>0) {
                    ConstantUtil.memoryTasks.clear();
                    for (MemoryTask memoryTask : memoryTasks) {
                        ConstantUtil.memoryTasks.offer(memoryTask);
                    }
                }
            }
            sendTaskATTime(systemConfig,now);
            try {
                Thread.sleep(30*1000);
                logger.debug("醒了,查看到通知时间没!");
            } catch (InterruptedException e) {
//                    e.printStackTrace();
            }
        }
    }
    public void sendTaskATTime(SystemConfig systemConfig,Date now) {
        String nowDate = now.toString();
        if (nowDate.contains("20:00:") || nowDate.contains("21:00:")|| nowDate.contains("18:30:")) {
            List<User> users = userDao.findUsersNoticeSpecial(new User());
            if (ObjectUtils.isEmpty(users)) {
                return ;
            }
            Calendar start = Calendar.getInstance();
            start.setTime(now);
            start.set(Calendar.HOUR,start.get(Calendar.HOUR)-20);
            MemoryTask memoryTask = new MemoryTask();
            memoryTask.setStartTime(start.getTime());
            memoryTask.setEndTime(now);

            for (User user : users) {
                memoryTask.setCreateById(user.getId());
                List<MemoryTask> memoryTasks = memoryTaskDao.findNoticedTask(memoryTask);
                if (ObjectUtils.isEmpty(memoryTasks)) {
                    continue;
                }
                String title = "今天需要记忆的任务！";
                String content = "";
                for (MemoryTask m : memoryTasks) {
                    content += "{" + m.getContent()+"},";
                }
                boolean send = MailSendUtils.sendEmail(systemConfig.getSmtp(), systemConfig.getPort(), systemConfig.getMailName(),
                        systemConfig.getMailPassword(), user.getEmail(), title, content, "1");
                if (send) {
                    logger.debug("今天需要记忆的任务已发送！");
                }
            }

        }
    }
}
