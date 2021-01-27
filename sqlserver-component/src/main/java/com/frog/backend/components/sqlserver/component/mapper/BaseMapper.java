package com.frog.backend.components.sqlserver.component.mapper;

import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.SqlServerMapper;

/**
 * Description 依赖tk.mybatis框架的通用Mapper
 *
 * @author yxy
 * @date 2021-01-26
 */
public interface BaseMapper<T> extends Mapper<T>, IdsMapper<T> {
}
