package com.leitianyu.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.leitianyu.reggie.entity.Category;


public interface CategoryService extends IService<Category> {


    /**
     * 查看分类是否关联菜品或套餐
     * @param id
     */
    public void remove(Long id);
}
