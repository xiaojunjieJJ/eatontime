package com.xiao.eatontime.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiao.common.utils.PageInfoResult;
import com.xiao.common.utils.PageQuery;
import com.xiao.eatontime.entity.ComboEntity;

import java.util.Map;

/**
 * 套餐
 *
 * @author XiaoJunJie
 * @email hninee@163.com
 * @date 2023-02-13 09:22:26
 */
public interface ComboService extends IService<ComboEntity> {

    PageInfoResult<ComboEntity> listCombos(PageQuery pageQuery);
}

