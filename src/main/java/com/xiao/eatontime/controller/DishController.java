package com.xiao.eatontime.controller;

import com.xiao.common.resp.ApiResult;
import com.xiao.common.resp.ApiUtil;
import com.xiao.common.utils.PageInfoResult;
import com.xiao.common.utils.PageQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.xiao.eatontime.entity.DishEntity;
import com.xiao.eatontime.service.DishService;

import java.util.Arrays;


/**
 * 菜品
 *
 * @author XiaoJunJie
 * @email hninee@163.com
 * @date 2023-02-13 09:22:26
 */
@RestController
@RequestMapping("eatontime/dish")
@Api(value = "菜品controller", tags = {"菜品接口"})
public class DishController {
    @Autowired
    private DishService dishService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation("分页查询菜品")
    public ApiResult<PageInfoResult<DishEntity>> list(@ModelAttribute PageQuery pageQuery) {
        return ApiUtil.success(dishService.listDishes(pageQuery));
    }

    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @ApiOperation("查询菜品详情")
    public ApiResult<DishEntity> info(@PathVariable("id") Long id) {
        DishEntity dish = dishService.getById(id);

        return ApiUtil.success(dish);
    }

    /**
     * 保存
     */
    @PutMapping("/save")
    @ApiOperation("新增菜品")
    public ApiResult save(@RequestBody DishEntity dish) {
        dishService.save(dish);

        return ApiUtil.success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改菜品")
    public ApiResult update(@RequestBody DishEntity dish) {
        dishService.updateById(dish);

        return ApiUtil.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @ApiOperation("删除菜品")
    public ApiResult delete(@RequestBody Long[] ids) {
        dishService.removeByIds(Arrays.asList(ids));

        return ApiUtil.success();
    }

}
