package com.xiao.eatontime.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.xiao.common.utils.PageInfoResult;
import com.xiao.common.utils.PageQuery;
import com.xiao.eatontime.entity.DishEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.xiao.eatontime.dao.CategoryDao;
import com.xiao.eatontime.entity.CategoryEntity;
import com.xiao.eatontime.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {


    @Override
    public PageInfoResult<CategoryEntity> listCategories(PageQuery pageQuery) {
        PageHelper.startPage(pageQuery.getPageNum(), pageQuery.getPageSize(), pageQuery.getOrderBy());
        LambdaQueryWrapper<CategoryEntity> wrapper = new QueryWrapper<CategoryEntity>().lambda();
        List<CategoryEntity> cats = baseMapper.selectList(wrapper);
        return new PageInfoResult<>(cats);
    }
}