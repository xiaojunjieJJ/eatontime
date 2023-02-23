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

import com.xiao.eatontime.entity.ComboEntity;
import com.xiao.eatontime.service.ComboService;


/**
 * 套餐
 *
 * @author XiaoJunJie
 * @email hninee@163.com
 * @date 2023-02-13 09:22:26
 */
@RestController
@RequestMapping("eatontime/combo")
@Api(value = "套餐controller", tags = {"套餐接口"})
public class ComboController {
    @Autowired
    private ComboService comboService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation("分页查询套餐")
    public ApiResult<PageInfoResult<ComboEntity>> list(@ModelAttribute PageQuery pageQuery) {
        PageInfoResult<ComboEntity> comboList = comboService.listCombos(pageQuery);

        return ApiUtil.success(comboList);
    }

    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @ApiOperation("查询套餐详情")
    public ApiResult<ComboEntity> info(@PathVariable("id") Long id) {
        ComboEntity combo = comboService.getById(id);

        return ApiUtil.success(combo);
    }

    /**
     * 保存
     */
    @PutMapping("/save")
    @ApiOperation("新增套餐")
    public ApiResult save(@RequestBody ComboEntity combo) {
        comboService.save(combo);

        return ApiUtil.success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改套餐")
    public ApiResult update(@RequestBody ComboEntity combo) {
        comboService.updateById(combo);

        return ApiUtil.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @ApiOperation("删除套餐")
    public ApiResult delete(@RequestBody Long[] ids) {
        comboService.removeByIds(Arrays.asList(ids));

        return ApiUtil.success();
    }


}
