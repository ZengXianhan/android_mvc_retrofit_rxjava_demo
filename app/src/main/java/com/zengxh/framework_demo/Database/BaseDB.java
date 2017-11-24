package com.zengxh.framework_demo.Database;

import java.util.List;

/**
 * Created by simtech on 24/11/2017.
 */

public interface BaseDB<T> {
    /**
     * 插入一条记录
     *
     * @param t
     */
    public void insert(T t) throws Exception;
    /**
     * 插入集合
     *
     * @param tList
     */
    public void insertList(List<T> tList) throws Exception;

    /**
     * 删除一条记录
     *
     * @param t
     */
    public void delete(T t) throws Exception;
    public void delete(String id) throws Exception;

    /**
     * 更新一条记录
     *
     * @param t
     */
    public void update(T t) throws Exception;
    public void update(String id) throws Exception;
    /**
     * 查询列表
     */
    public List<T> readList() throws Exception;
    /**
     * 查询一条记录
     */
    public T read(String id) throws Exception;
}
