package com.xiao.eatontime.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.xiao.eatontime.dao.ComboDishDao;
import com.xiao.eatontime.entity.ComboDishEntity;
import com.xiao.eatontime.service.ComboDishService;


@Service("comboDishService")
public class ComboDishServiceImpl extends ServiceImpl<ComboDishDao, ComboDishEntity> implements ComboDishService {



}