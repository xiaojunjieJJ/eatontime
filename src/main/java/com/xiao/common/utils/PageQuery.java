package com.xiao.common.utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class PageQuery implements Serializable {
    /**
     * 当前页
     */
    @ApiModelProperty(value = "当前页", required = true)
    private int pageNum = 1;

    /**
     * 每页显示条数，默认 10
     */
    @ApiModelProperty(value = "每页数量", required = true)
    private int pageSize = 10;

    /**
     * 排序(字段 规则)，默认 create_time desc
     */
    @ApiModelProperty(value = "排序(字段 规则)")
    private String orderBy = "create_time desc";
}
