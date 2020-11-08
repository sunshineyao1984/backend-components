package com.frog.backend.components.mysql.component.mapper;

import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Description 依赖tk.mybatis框架的通用Mapper
 *
 * @author yxy
 * @date 2020-10-10
 */
public interface BaseMapper<T> extends Mapper<T>, IdsMapper<T>, MySqlMapper<T> {
}
