package com.atstudy.service;

import com.atstudy.pojo.Category;
import com.atstudy.pojo.bo.CategoryAddBo;
import com.atstudy.pojo.bo.CategoryBo;
import com.atstudy.pojo.bo.CategoryUpdateBo;
import com.atstudy.pojo.bo.PageBo;

import java.util.List;

public interface CategoryService {

    /**
     * 通过条件查询分类列表
     * @param categoryBo
     * @param pageBo
     * @return
     */
    List<Category> listByCategoryBo(CategoryBo categoryBo, PageBo pageBo);

    /**
     * 直接查询出分类列表
     * @return
     */
    List<Category> list();

    /**
     * 通过分类名称查询分类名称是否重复
     * @return
     */
    boolean confirmCateName(String cateName);

    /**
     * 通过添加信息添加分类
     * @return
     */
    boolean insertByCategoryAddBo(CategoryAddBo categoryAddBo);

    /**
     * 通过分类id查询单条分类数据
     * @return
     */
    Category findByCateId(String cateId);

    /**
     * 根据updateBo进行修改分类
     * @return
     */
    boolean updateByCateUpdateBo(CategoryUpdateBo categoryUpdateBo);
}
