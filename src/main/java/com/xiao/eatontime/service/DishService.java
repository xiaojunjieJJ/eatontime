package com.xiao.eatontime.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiao.common.utils.PageInfoResult;
import com.xiao.common.utils.PageQuery;
import com.xiao.eatontime.entity.DishEntity;

import java.util.Map;

/**
 * 菜品
 *
 * @author XiaoJunJie
 * @email hninee@163.com
 * @date 2023-02-13 09:22:26
 */
public interface DishService extends IService<DishEntity> {

    PageInfoResult<DishEntity> listDishes(PageQuery pageQuery);
}

