package com.leitianyu.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leitianyu.reggie.common.R;
import com.leitianyu.reggie.entity.Category;
import com.leitianyu.reggie.entity.Employee;
import com.leitianyu.reggie.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
分类管理
 */
@Slf4j
@RestController
@RequestMapping("/category")
public class CategoryServiceController {
    @Autowired
    private CategoryService categoryService;
    /*
    新增分类
     */
    @PostMapping
    public R<String> save(@RequestBody Category category){
        log.info("category：{}",category.toString());
        categoryService.save(category);
        return R.success("新增分类成功");
    }

    @GetMapping("/page")
    public R<Page> page(int page, int pageSize){
        //分页构造器
        Page<Category> pageSearch = new Page<>(page,pageSize);
        //条件构造器
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        //添加排序条件
        queryWrapper.orderByAsc(Category::getSort);

        //执行查询
        categoryService.page(pageSearch,queryWrapper);
        return R.success(pageSearch);
    }
}
