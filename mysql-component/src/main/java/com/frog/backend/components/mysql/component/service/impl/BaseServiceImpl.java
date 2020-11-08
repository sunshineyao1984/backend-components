package com.frog.backend.components.mysql.component.service.impl;



import com.frog.backend.components.mysql.component.mapper.BaseMapper;
import com.frog.backend.components.mysql.component.service.BaseService;

import java.util.List;

/**
 * Description 基础Service实现类
 *
 * @author yxy
 * @date 2020-10-10
 */
public abstract class BaseServiceImpl<T,ID> implements BaseService<T,ID> {

    /**
     * 获取Mapper实例s
     * @return
     */
    protected abstract BaseMapper<T> getMapper();

    @Override
    public int insert(T t) {
        return getMapper().insert(t);
    }

    @Override
    public int insertSelective(T t) {
        return getMapper().insertSelective(t);
    }

    @Override
    public int insertUseGeneratedKeys(T t) {
        return getMapper().insertUseGeneratedKeys(t);
    }

    @Override
    public int insertList(List<? extends T> list) {
        return getMapper().insertList(list);
    }

    @Override
    public int delete(T t) {
        return getMapper().delete(t);
    }

    @Override
    public int deleteById(ID id) {
        return getMapper().deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByIds(String ids) {
        return getMapper().deleteByIds(ids);
    }

    @Override
    public int deleteByExample(Object example) {
        return getMapper().deleteByExample(example);
    }

    @Override
    public T selectOne(T t) {
        return getMapper().selectOne(t);
    }

    @Override
    public List<T> select(T t) {
        return getMapper().select(t);
    }

    @Override
    public T selectById(ID id) {
        return getMapper().selectByPrimaryKey(id);
    }

    @Override
    public List<T> selectByIds(String ids) {
        return getMapper().selectByIds(ids);
    }

    @Override
    public List<T> selectAll() {
        return getMapper().selectAll();
    }

    @Override
    public int selectCount(T t) {
        return getMapper().selectCount(t);
    }

    @Override
    public List<T> selectByExample(Object example) {
        return getMapper().selectByExample(example);
    }

    @Override
    public T selectOneByExample(Object example) {
        return getMapper().selectOneByExample(example);
    }

    @Override
    public int selectCountByExample(Object example) {
        return getMapper().selectCountByExample(example);
    }

    @Override
    public int updateById(T t) {
        return getMapper().updateByPrimaryKey(t);
    }

    @Override
    public int updateByIdSelective(T t) {
        return getMapper().updateByPrimaryKeySelective(t);
    }

    @Override
    public int updateByExample(T t, Object example) {
        return getMapper().updateByExample(t,example);
    }

    @Override
    public int updateByExampleSelective(T t, Object example) {
        return getMapper().updateByExampleSelective(t,example);
    }
}
