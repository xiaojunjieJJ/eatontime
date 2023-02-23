package com.xiao.eatontime.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 购物车
 * 
 * @author XiaoJunJie
 * @email hninee@163.com
 * @date 2023-02-13 09:22:26
 */
@Data
@TableName("cart")
public class CartEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 菜名
	 */
	private String dishName;
	/**
	 * 图片地址
	 */
	private String pictureUrl;
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 菜品id
	 */
	private Long dishId;
	/**
	 * 套餐id
	 */
	private Long comboId;
	/**
	 * 数量
	 */
	private Integer dishCount;
	/**
	 * 单价
	 */
	private BigDecimal price;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date updateTime;
	/**
	 * 删除标志
	 */
	private Integer delFlag;

}
