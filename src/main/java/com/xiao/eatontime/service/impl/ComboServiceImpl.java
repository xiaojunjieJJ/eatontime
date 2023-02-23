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

import com.xiao.eatontime.dao.ComboDao;
import com.xiao.eatontime.entity.ComboEntity;
import com.xiao.eatontime.service.ComboService;


@Service("comboService")
public class ComboServiceImpl extends ServiceImpl<ComboDao, ComboEntity> implements ComboService {


    @Override
    public PageInfoResult<ComboEntity> listCombos(PageQuery pageQuery) {
        PageHelper.startPage(pageQuery.getPageNum(), pageQuery.getPageSize(), pageQuery.getOrderBy());
        LambdaQueryWrapper<ComboEntity> wrapper = new QueryWrapper<ComboEntity>().lambda();
        List<ComboEntity> combos = baseMapper.selectList(wrapper);
        return new PageInfoResult<>(combos);
    }
}