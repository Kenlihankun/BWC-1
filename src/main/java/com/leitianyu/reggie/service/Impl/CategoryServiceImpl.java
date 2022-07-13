package com.leitianyu.reggie.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leitianyu.reggie.common.CustomException;
import com.leitianyu.reggie.entity.Category;
import com.leitianyu.reggie.entity.Dish;
import com.leitianyu.reggie.entity.Setmeal;
import com.leitianyu.reggie.mapper.CategoryMapper;
import com.leitianyu.reggie.service.CategoryService;
import com.leitianyu.reggie.service.DishService;
import com.leitianyu.reggie.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    @Autowired
    private DishService dishService;
    @Autowired
    private SetmealService setmealService;
    @Override
    public void remove(Long id) {
        //定义比较规则
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dishLambdaQueryWrapper.eq(Dish::getCategoryId,id);
        int count1 = dishService.count(dishLambdaQueryWrapper);
        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId,id);
        int count2 = setmealService.count(setmealLambdaQueryWrapper);
        //判断是否关联菜品
        if (count1>0){
            throw new CustomException("当前分类关联了菜品，不能删除");
        }
        //判断是否关联套餐
        if (count2>0){
            throw new CustomException("当前分类关联了套餐，不能删除");
        }
        //正常删除
        super.removeById(id);
    }
}
