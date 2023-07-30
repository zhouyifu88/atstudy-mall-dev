package com.atstudy.controller;

import com.atstudy.mapper.CategoryMapper;
import com.atstudy.pojo.Spu;
import com.atstudy.pojo.bo.PageBo;
import com.atstudy.pojo.bo.SpuAddBo;
import com.atstudy.pojo.bo.SpuSearchBo;
import com.atstudy.pojo.bo.SpuUpdateBo;
import com.atstudy.service.BrandService;
import com.atstudy.service.SpuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/spu")
public class SpuController {
    @Resource
    private SpuService spuService;

    @Resource
    private BrandService brandService;

    @Resource
    private CategoryMapper categoryMapper;

    @RequestMapping("/delete")
    public String delete(Long spuId,Long[] idList){
        boolean result;
        if (spuId != null){
            result = spuService.deleteOne(spuId);
        }else {
            result = spuService.deleteBatch(idList);
        }
        if (result){
            return "redirect:/index/success?message=delete success";
        }else {
            return "redirect:/index/success?message=delete error";
        }
    }

    @PostMapping("/alter")
    public String alter(SpuUpdateBo spuUpdateBo){
        boolean result = spuService.updateOne(spuUpdateBo);
        if (result){
            return "redirect:/index/success?message=update success";
        }else {
            return "redirect:/index/success?message=update error";
        }
    }

    @RequestMapping("/update")
    public String update(Long spuId,Model model){
        model.addAttribute("brandList",brandService.list());
        model.addAttribute("cateList",categoryMapper.list());
        Spu spu = spuService.selectById(spuId);
        List<Integer> cateIdList = spuService.listCateIdBySpuId(spuId);
        model.addAttribute("spu",spu);
        model.addAttribute("cateIdList",cateIdList);
        return "spu/update";
    }

    @PostMapping("/save")
    public String save(SpuAddBo spuAddBo){
        boolean result = spuService.insertOne(spuAddBo);
        if (result){
            return "redirect:/index/success?message=save success";
        }else {
            return "redirect:/index/success?message=save error";
        }
    }

    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("brandList",brandService.list());
        model.addAttribute("cateList",categoryMapper.list());
        return "spu/add";
    }

    @RequestMapping("/admin")
    public String admin(SpuSearchBo spuSearchBo, PageBo pageBo, Model model){
        model.addAttribute("spuSearchBo",spuSearchBo);
        model.addAttribute("pageBo",pageBo);
        model.addAttribute("brandList",brandService.list());
        model.addAttribute("cateList",categoryMapper.list());
        List<Spu> spuList = spuService.listBySearchBo(spuSearchBo, pageBo);
        model.addAttribute("spuList",spuList);
        return "spu/admin";
    }
}
