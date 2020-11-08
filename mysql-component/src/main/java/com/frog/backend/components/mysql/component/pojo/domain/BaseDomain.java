package com.frog.backend.components.mysql.component.pojo.domain;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Description
 *
 * @author yxy
 * @date 2020-10-10
 */
@Data
public class BaseDomain {

    /**
     * 创建时间
     */
    protected LocalDateTime createTime;

    /**
     * 更新时间
     */
    protected LocalDateTime updateTime;
}
