package com.atstudy.service.impl;

import com.atstudy.mapper.CategoryMapper;
import com.atstudy.pojo.Category;
import com.atstudy.pojo.bo.CategoryAddBo;
import com.atstudy.pojo.bo.CategoryBo;
import com.atstudy.pojo.bo.CategoryUpdateBo;
import com.atstudy.pojo.bo.PageBo;
import com.atstudy.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> listByCategoryBo(CategoryBo categoryBo, PageBo pageBo) {
        long result = categoryMapper.countByCategoryBo(categoryBo);
        pageBo.setResultCount(result);
        List<Category> categories = categoryMapper.listByCategoryBo(categoryBo, pageBo);
        return categories;
    }

    @Override
    public List<Category> list() {
        List<Category> list = categoryMapper.list();
        return list;
    }

    @Override
    public boolean confirmCateName(String cateName) {
        int i = categoryMapper.selectByCateName(cateName);
        return i >= 1;
    }

    @Transactional
    @Override
    public boolean insertByCategoryAddBo(CategoryAddBo categoryAddBo) {
        Category category = new Category();
        category.setCateName(categoryAddBo.getCateName());
        category.setCateSort(categoryAddBo.getCateSort());
        category.setCateParentid(categoryAddBo.getCateParentid());
        LocalDate date = LocalDate.now();
        category.setCreatetime(date);
        category.setUpdatetime(date);
        int a = categoryMapper.insertByCategory(category);
        return a >= 1;
    }

    @Override
    public Category findByCateId(String cateId) {
        Category category = categoryMapper.findByCateId(cateId);
        return category;
    }

    @Transactional
    @Override
    public boolean updateByCateUpdateBo(CategoryUpdateBo categoryUpdateBo) {
        Category category = new Category();
        category.setCateId(categoryUpdateBo.getCateId());
        category.setCateName(categoryUpdateBo.getCateName());
        category.setCateSort(categoryUpdateBo.getCateSort());
        category.setCateParentid(categoryUpdateBo.getCateParentid());
        category.setUpdatetime(LocalDate.now());
        //通过Category类修改分类
        int i = categoryMapper.updateByCategory(category);
        return i >= 1;
    }
}
