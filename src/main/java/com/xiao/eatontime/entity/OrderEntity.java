package com.xiao.eatontime.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 订单
 * 
 * @author XiaoJunJie
 * @email hninee@163.com
 * @date 2023-02-13 09:22:26
 */
@Data
@TableName("order")
public class OrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 订单号
	 */
	private String orderNumber;
	/**
	 * 订单状态：待付款/待配送/已派送/已完成/已取消
	 */
	private Integer status;
	/**
	 * 下单用户
	 */
	private Long userId;
	/**
	 * 地址/公司
	 */
	private Long addressId;
	/**
	 * 支付方式
	 */
	private Integer payType;
	/**
	 * 支付金额
	 */
	private BigDecimal payAmount;
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
