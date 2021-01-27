package com.frog.backend.components.sqlserver.component.util;

import tk.mybatis.mapper.genid.GenId;

import java.util.UUID;

/**
 * Description
 *
 * @author yxy
 * @date 2021-01-27
 */
public class UUIDGenId implements GenId {
    @Override
    public Object genId(String s, String s1) {
        return UUID.randomUUID().toString().replace("-","");
    }
}
