package com.xiao.eatontime.dao;

import com.xiao.eatontime.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author XiaoJunJie
 * @email hninee@163.com
 * @date 2023-02-13 09:22:26
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
