package com.leitianyu.reggie.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leitianyu.reggie.entity.Category;
import com.leitianyu.reggie.mapper.CategoryMapper;
import com.leitianyu.reggie.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
}
