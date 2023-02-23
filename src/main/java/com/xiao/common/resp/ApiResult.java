package com.xiao.common.resp;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResult<T> {
    /**
     * 响应代码
     */
    @ApiModelProperty(value ="响应代码")
    private int code;

    /**
     * 响应结果
     */
    @ApiModelProperty(value ="响应代结果")
    private String msg;

    /**
     * 响应数据
     */
    @ApiModelProperty(value ="响应数据")
    private T data;
}
