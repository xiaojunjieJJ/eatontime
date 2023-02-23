package com.xiao.eatontime.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xiao.eatontime.entity.AddressEntity;
import com.xiao.eatontime.service.AddressService;


/**
 * 收获地址
 *
 * @author XiaoJunJie
 * @email hninee@163.com
 * @date 2023-02-13 09:22:26
 */
@RestController
@RequestMapping("eatontime/address")
public class AddressController {
    @Autowired
    private AddressService addressService;
//
//    /**
//     * 列表
//     */
//    @RequestMapping("/list")
//    public R list(@RequestParam Map<String, Object> params){
//        PageUtils page = addressService.queryPage(params);
//
//        return R.ok().put("page", page);
//    }
//
//
//    /**
//     * 信息
//     */
//    @RequestMapping("/info/{id}")
//    public R info(@PathVariable("id") Long id){
//		AddressEntity address = addressService.getById(id);
//
//        return R.ok().put("address", address);
//    }
//
//    /**
//     * 保存
//     */
//    @RequestMapping("/save")
//    public R save(@RequestBody AddressEntity address){
//		addressService.save(address);
//
//        return R.ok();
//    }
//
//    /**
//     * 修改
//     */
//    @RequestMapping("/update")
//    public R update(@RequestBody AddressEntity address){
//		addressService.updateById(address);
//
//        return R.ok();
//    }
//
//    /**
//     * 删除
//     */
//    @RequestMapping("/delete")
//    public R delete(@RequestBody Long[] ids){
//		addressService.removeByIds(Arrays.asList(ids));
//
//        return R.ok();
//    }

}
