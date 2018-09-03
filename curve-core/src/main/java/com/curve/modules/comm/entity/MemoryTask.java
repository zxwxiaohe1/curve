package com.curve.modules.comm.entity;

import com.curve.core.utils.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author: Created by heyong.
 * @createtime: on 2018/8/19.
 * @copyright&copy: <a href="http://www.sinux.com.cn">JFusion</a> All rights reserved
 */
public class MemoryTask extends BaseEntity<MemoryTask> {
    private String title;
    private String content;
    private String todo;
    private Date noticeDate;
    private String link;
    private User user;
    private Date startTime;
    private Date endTime;
    public MemoryTask() {
    }

    public MemoryTask(String id) {
        super(id);
    }

    public boolean updateLink() {
        if (StringUtils.isNotBlank(this.link)) {

            String[] links = this.link.split(",");
            for (int i = 0; i < links.length; i++) {
                String l = links[i];
                if (l.startsWith("0:")) {
                    l = l.replaceAll("0:", "1:");
                    links[i] = l;
                    break;
                }
            }
            String temp = "";
            for (String k : links) {
                temp = temp + "," + k;
            }
            if (temp.startsWith(",")) {
                temp = temp.substring(",".length());
            }
            if (temp.endsWith(",")) {
                temp = temp.substring(0,temp.length()-1);
            }
            this.link = temp;
        } else {
            return false;
        }
        return true;
    }

    public boolean isDoFanish() {
        if (this.link.contains("0:")) {
            return false;
        }
        return true;
    }

    public void updateNoticeDate() {
        if (StringUtils.isNotBlank(this.link)) {
            String[] links = this.link.split(",");
            if (links.length > 0) {
                for (String l : links) {
                    if (l.startsWith("0:")) {
                        String date = l.substring("0:".length()).trim();
                        if (StringUtils.isNotBlank(date)) {
                            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            Calendar c = Calendar.getInstance();
                            System.out.println("当前日期:" + sf.format(c.getTime()));
                            c.add(Calendar.DATE, Integer.parseInt(date));
                            System.out.println("增加" + date + "天后日期:" + sf.format(c.getTime()));
                            this.noticeDate = c.getTime();
                        }
//                        l.replaceAll("0:", "1:");
                        break;
                    }
                }
//                this.link = links.toString();
            }
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public Date getNoticeDate() {
        return noticeDate;
    }

    public void setNoticeDate(Date noticeDate) {
        this.noticeDate = noticeDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
