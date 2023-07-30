package com.atstudy.controller;

import com.atstudy.pojo.Brand;
import com.atstudy.pojo.bo.BrandSearchBo;
import com.atstudy.pojo.bo.PageBo;
import com.atstudy.service.BrandService;
import com.atstudy.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/brand")
public class BrandController {
    @Resource
    private BrandService brandService;

    @Resource
    private CategoryService categoryService;

    @RequestMapping("/delete")
    public String delete(String brandId,String[] idList){
        boolean result;
        if (brandId != null){
            //删除单个
            result = brandService.deleteOne(brandId);
        }else{
            //删除多个
            result = brandService.deleteList(idList);
        }

        if (result){
            return "redirect:/index/success?message=delete success";
        }else {
            return "redirect:/index/success?message=delete error";
        }
    }

    @RequestMapping("/update")
    public String update(){
        return "brand/update";
    }

    @RequestMapping("/add")
    public String add(){
        return "brand/add";
    }

    @RequestMapping("/admin")
    public String admin(BrandSearchBo searchBo, PageBo pageBo, Model model){
        List<Brand> brandList = brandService.listByBo(searchBo, pageBo);
        model.addAttribute("searchBo",searchBo);
        model.addAttribute("pageBo",pageBo);
        model.addAttribute("brandList",brandList);
        model.addAttribute("list",categoryService.list());
        return "brand/admin";
    }
}
