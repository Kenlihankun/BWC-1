package com.leitianyu.reggie.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leitianyu.reggie.entity.Setmeal;
import com.leitianyu.reggie.mapper.SetmealMapper;
import com.leitianyu.reggie.service.SetmealService;
import org.springframework.stereotype.Service;

@Service
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal> implements SetmealService {
}
