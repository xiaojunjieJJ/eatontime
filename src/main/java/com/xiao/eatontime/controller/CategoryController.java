package com.xiao.eatontime.controller;

import java.util.Arrays;

import com.xiao.common.resp.ApiResult;
import com.xiao.common.resp.ApiUtil;
import com.xiao.common.utils.PageInfoResult;
import com.xiao.common.utils.PageQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.xiao.eatontime.entity.CategoryEntity;
import com.xiao.eatontime.service.CategoryService;


/**
 * 菜品分类
 *
 * @author XiaoJunJie
 * @email hninee@163.com
 * @date 2023-02-13 09:22:26
 */
@RestController
@RequestMapping("eatontime/category")
@Api(value = "菜品分类controller", tags = {"菜品分类接口"})
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation("分页查询菜品分类")
    public ApiResult<PageInfoResult<CategoryEntity>> list(@ModelAttribute PageQuery pageQuery) {
        PageInfoResult<CategoryEntity> catList = categoryService.listCategories(pageQuery);

        return ApiUtil.success(catList);
    }

    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @ApiOperation("查询菜品分类详情")
    public ApiResult<CategoryEntity> info(@PathVariable("id") Long id) {
        CategoryEntity category = categoryService.getById(id);

        return ApiUtil.success(category);
    }

    /**
     * 保存
     */
    @PutMapping("/save")
    @ApiOperation("新增菜品分类")
    public ApiResult save(@RequestBody CategoryEntity category) {
        categoryService.save(category);

        return ApiUtil.success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改菜品分类")
    public ApiResult update(@RequestBody CategoryEntity category) {
        categoryService.updateById(category);

        return ApiUtil.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @ApiOperation("删除菜品")
    public ApiResult delete(@RequestBody Long[] ids) {
        categoryService.removeByIds(Arrays.asList(ids));

        return ApiUtil.success();
    }

}
