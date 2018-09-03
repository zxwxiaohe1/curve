/**
 * Copyright &copy; 2015-2020 <a href="http://www.sinux.com.cn/">JFusion</a> All rights reserved.
 */
package com.curve.modules.comm.entity;

import com.curve.core.utils.IdGen;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * Entity支持类
 *
 * @author heyong
 * @version 2018-05-16
 */
public abstract class BaseEntity<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    /**实体编号（唯一标识）*/
    protected String id;
    /**创建日期*/
    protected Date createDate;
    /** 更新日期*/
    protected Date updateDate;
    /**创建人ID*/
    protected String createById;
    /**更新人ID*/
    protected String updateById;
    /**备注*/
    protected String remarks;
    /**删除标记（0：正常；1：删除；2：审核）*/
    protected String delFlag = "0";
    protected boolean isNewRecord;
    public BaseEntity(){
    }
    public BaseEntity(String id){
        this.id = id;
    }
    /**
     * 插入之前执行方法，需要手动调用
     */
    public void preInsert() {
        // 不限制ID为UUID，调用setIsNewRecord()使用自定义ID
        setId(IdGen.uuid());
        this.updateDate = new Date();
        this.updateById = "1";
        this.createDate = this.updateDate;
        this.createById = "1";
    }
    public void preUpdate() {
        this.updateDate = new Date();
        this.updateById = "1";
        this.createById = "1";
    }

    /**
     * 删除标记（0：正常；1：删除；2：审核；）
     */
    public static final String DEL_FLAG_NORMAL = "0";
    public static final String DEL_FLAG_DELETE = "1";
    public static final String DEL_FLAG_AUDIT = "2";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getCreateById() {
        return createById;
    }

    public void setCreateById(String createById) {
        this.createById = createById;
    }

    public String getUpdateById() {
        return updateById;
    }

    public void setUpdateById(String updateById) {
        this.updateById = updateById;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public boolean isNewRecord() {
        return isNewRecord;
    }

    public void setNewRecord(boolean newRecord) {
        isNewRecord = newRecord;
    }
}
