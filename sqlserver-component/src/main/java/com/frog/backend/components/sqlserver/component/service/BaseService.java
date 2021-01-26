package com.frog.backend.components.sqlserver.component.service;

import java.util.List;

/**
 * Description 基础Service
 *
 * @author yxy
 * @date 2020-10-10
 */
public interface BaseService<T,ID> {

    /**
     * 插入一个实体
     * @param t
     * @return
     */
    int insert(T t);

    /**
     * 插入一个实体的非null属性
     * @param t
     * @return
     */
    int insertSelective(T t);

//    /**
//     * 插入一个实体，并回填主键值
//     * @param t
//     * @return
//     */
//    int insertUseGeneratedKeys(T t);
//
//    /**
//     * 插入实体列表，支持批量插入的数据库可以使用，例如MySQL,H2等，另外该接口限制实体包含`id`属性并且必须为自增列
//     * @param list
//     * @return
//     */
//    int insertList(List<? extends T> list);

    /**
     * 删除实体
     * @param t
     * @return
     */
    int delete(T t);

    /**
     * 根据主键删除实体
     * @param id
     * @return
     */
    int deleteById(ID id);

    /**
     * 根据主键批量删除,主键之间用逗号分隔
     * @param ids
     * @return
     */
    int deleteByIds(String ids);

    /**
     * 根据Example条件删除数据，返回删除的条数
     * @param example
     * @return
     */
    int deleteByExample(Object example);

    /**
     * 根据实体中的属性查询，只能有一条记录值，有多条记录时会抛出异常
     * @param t
     * @return
     */
    T selectOne(T t);

    /**
     * 根据实体查询，取多条记录
     * @param t
     * @return
     */
    List<T> select(T t);

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    T selectById(ID id);

    /**
     * 根据主键批量查询,主键之间用逗号分隔
     * @param ids
     * @return
     */
    List<T> selectByIds(String ids);

    /**
     * 查询全部记录
     * @return
     */
    List<T> selectAll();

    /**
     * 根据实体查询记录数
     * @param t
     * @return
     */
    int selectCount(T t);

    /**
     * 根据example条件查询
     * @param example
     * @return
     */
    List<T> selectByExample(Object example);

    /**
     * 根据example条件查询,若有多条记录则会抛出异常
     * @param example
     * @return
     */
    T selectOneByExample(Object example);

    /**
     * 根据example条件查询记录总数
     * @param example
     * @return
     */
    int selectCountByExample(Object example);

    /**
     * 根据主键更新实体中的属性
     * @param t
     * @return
     */
    int updateById(T t);

    /**
     * 根据主键更新实体中的非null属性
     * @param t
     * @return
     */
    int updateByIdSelective(T t);

    /**
     * 根据Example条件更新实体`t`包含的全部属性，null值会被更新，返回更新的条数
     * @param t
     * @param example
     * @return
     */
    int updateByExample(T t, Object example);

    /**
     * 根据Example条件更新实体`t`包含的不是null的属性值，返回更新的条数
     * @param t
     * @param example
     * @return
     */
    int updateByExampleSelective(T t, Object example);

}
