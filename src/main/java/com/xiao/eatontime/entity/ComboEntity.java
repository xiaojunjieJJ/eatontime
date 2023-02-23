package com.xiao.eatontime.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 套餐
 *
 * @author XiaoJunJie
 * @email hninee@163.com
 * @date 2023-02-13 09:22:26
 */
@Data
@TableName("combo")
public class ComboEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 套餐名
     */
    private String comboName;
    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 分类id
     */
    private Long categoryId;
    /**
     * 销量
     */
    private Integer saleCount;
    /**
     * 描述/备注
     */
    private String description;
    /**
     * 上架状态
     */
    private Integer status;
    /**
     * 排序号
     */
    private Integer sortNumber;
    /**
     * 图片地址
     */
    private String pictureUrl;
    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 修改时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "更新时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    /**
     * 删除标志
     */
    @TableField(value = "del_flag")
    @TableLogic
    @ApiModelProperty(value = "删除标识")
    @JsonIgnore
    private Integer delFlag;

}
