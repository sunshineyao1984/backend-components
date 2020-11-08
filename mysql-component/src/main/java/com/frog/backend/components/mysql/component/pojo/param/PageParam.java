package com.frog.backend.components.mysql.component.pojo.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Description
 *
 * @author yxy
 * @date 2020-10-10
 */
@Data
public class PageParam {

    /**
     * 第几页，从1开始
     */
    @ApiModelProperty(value = "页码")
    @NotNull(message = "页码不能为空!")
    @Min(value = 1)
    protected Integer pageNum = 1;

    /**
     * 页尺寸
     */
    @ApiModelProperty(value = "每页显示数")
    @NotNull(message = "页尺寸不能为空！")
    @Min(1)
    @Max(500)
    protected Integer pageSize = 20;

    /**
     * 排序 例如： id desc
     */
    protected String orderBy;
}
