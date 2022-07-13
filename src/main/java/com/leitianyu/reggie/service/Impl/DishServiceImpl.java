package com.leitianyu.reggie.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leitianyu.reggie.entity.Dish;
import com.leitianyu.reggie.mapper.DishMapper;
import com.leitianyu.reggie.service.DishService;
import org.springframework.stereotype.Service;

@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {
}
