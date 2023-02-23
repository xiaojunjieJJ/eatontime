package com.xiao.eatontime.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xiao.eatontime.entity.CartEntity;
import com.xiao.eatontime.service.CartService;


/**
 * 购物车
 *
 * @author XiaoJunJie
 * @email hninee@163.com
 * @date 2023-02-13 09:22:26
 */
@RestController
@RequestMapping("eatontime/cart")
public class CartController {
    @Autowired
    private CartService cartService;
//
//    /**
//     * 列表
//     */
//    @RequestMapping("/list")
//    public R list(@RequestParam Map<String, Object> params){
//        PageUtils page = cartService.queryPage(params);
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
//		CartEntity cart = cartService.getById(id);
//
//        return R.ok().put("cart", cart);
//    }
//
//    /**
//     * 保存
//     */
//    @RequestMapping("/save")
//    public R save(@RequestBody CartEntity cart){
//		cartService.save(cart);
//
//        return R.ok();
//    }
//
//    /**
//     * 修改
//     */
//    @RequestMapping("/update")
//    public R update(@RequestBody CartEntity cart){
//		cartService.updateById(cart);
//
//        return R.ok();
//    }
//
//    /**
//     * 删除
//     */
//    @RequestMapping("/delete")
//    public R delete(@RequestBody Long[] ids){
//		cartService.removeByIds(Arrays.asList(ids));
//
//        return R.ok();
//    }

}
