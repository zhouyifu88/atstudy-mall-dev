package com.atstudy.controller;

import com.atstudy.pojo.Category;
import com.atstudy.pojo.bo.CategoryAddBo;
import com.atstudy.pojo.bo.CategoryBo;
import com.atstudy.pojo.bo.CategoryUpdateBo;
import com.atstudy.pojo.bo.PageBo;
import com.atstudy.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/category")
@Slf4j
public class CategoryController {
    @Resource
    private CategoryService categoryService;

    @RequestMapping("/alter")
    public String alter(CategoryUpdateBo categoryUpdateBo){
        boolean result = categoryService.updateByCateUpdateBo(categoryUpdateBo);
        if (result){
            return "redirect:/index/success?message=update success";
        }else {
            return "redirect:/index/success?message=update error";
        }
    }

    @RequestMapping("/update")
    public String alter(String cateId,Model model){
        Category category = categoryService.findByCateId(cateId);
        model.addAttribute("category",category);
        model.addAttribute("list",categoryService.list());
        return "category/update";
    }

    @RequestMapping("/save")
    public String save(CategoryAddBo categoryAddBo){
        boolean result = categoryService.insertByCategoryAddBo(categoryAddBo);
        if (result){
            return "redirect:/index/success?message=save success";
        }else {
            return "redirect:/index/success?message=save error";
        }
    }

    @RequestMapping("/validate")
    @ResponseBody
    public String validate(String cateName){
        boolean result = categoryService.confirmCateName(cateName);
        return result?"true":"false";
    }

    @RequestMapping("/add")
    public String add(Model model){
        List<Category> list = categoryService.list();
        model.addAttribute("list",list);
        return "category/add";
    }

    @RequestMapping("/admin")
    public String admin(CategoryBo categoryBo, PageBo pageBo, Model model){
        List<Category> categoryList = categoryService.listByCategoryBo(categoryBo, pageBo);
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("categoryBo",categoryBo);
        model.addAttribute("pageBo",pageBo);
        model.addAttribute("list",categoryService.list());
        return "category/admin";
    }
}
