package com.xiao.eatontime.dao;

import com.xiao.eatontime.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 菜品分类
 * 
 * @author XiaoJunJie
 * @email hninee@163.com
 * @date 2023-02-13 09:22:26
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
