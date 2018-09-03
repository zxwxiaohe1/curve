package com.curve.modules.comm.dao;

import java.util.List;
/**
 * Entity支持类
 * @author heyong
 * @version 2018-08-16
 */
public interface BaseDao<T> {

    /**
     * 获取单条数据
     * @param t
     * @return
     */
    T get(T t);

    /**
     * 按条件查询
     * 
     * @param t
     * @return
     */
    List<T> select(T t);

    /**
     * 按条件查询 兼容老版本
     * 
     * @param t
     * @return
     */
    List<T> findList(T t);

    /**
     * 查询所有
     * @Title: findAllList
     * @Description: 
     * @return
     * @return: List<T>
     */
    List<T> findAllList();

    /**
     * 单条插入
     * 
     * @param t
     * @return
     */
    Integer insert(T t);

    /**
     * 根据主键修改，且只修改传入对象中有值的字段
     * 
     * @param t
     * @return
     */
    Integer update(T t);

    /**
     * 删除数据（逻辑删除，更新del_flag字段为1,在表包含字段del_flag时，可以调用此方法，将数据隐藏）
     * @param t
     * @return
     */
    Integer deleteByLogic(T t);

    /**
     * 默认删除方法
     * @Title: delete
     * @Description: 
     * @param t
     * @return: void
     */
    Integer delete(T t);
}
