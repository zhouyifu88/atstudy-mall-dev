package com.atstudy.controller;

import com.atstudy.pojo.SpuAttrKey;
import com.atstudy.pojo.bo.PageBo;
import com.atstudy.pojo.bo.SpuAttrKeyAddBo;
import com.atstudy.pojo.bo.SpuAttrKeySearchBo;
import com.atstudy.pojo.bo.SpuAttrUpdateBo;
import com.atstudy.service.CategoryService;
import com.atstudy.service.SpuAttrKeyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/attr")
@Slf4j
public class AttrController {

    @Resource
    private SpuAttrKeyService spuAttrKeyService;

    @Resource
    private CategoryService categoryService;

    @RequestMapping("/delete")
    public String delete(String keyId,String[] idList){
        boolean result;
        if (keyId != null){
            result = spuAttrKeyService.deleteOne(keyId);
        }else {
            result = spuAttrKeyService.deleteBatchIds(idList);
        }
        if (result){
            return "redirect:/index/success?message=delete success";
        }else {
            return "redirect:/index/success?message=delete error";
        }
    }

    @PostMapping("/alter")
    public String alter(SpuAttrUpdateBo spuAttrUpdateBo){
        boolean result = spuAttrKeyService.updateByBo(spuAttrUpdateBo);
        if (result){
            return "redirect:/index/success?message=update success";
        }else {
            return "redirect:/index/success?message=update error";
        }
    }

    @RequestMapping("/update")
    public String update(String keyId,Model model){
        SpuAttrKey spuAttrKey = spuAttrKeyService.listById(keyId);
        List<Integer> integerList = spuAttrKeyService.listCateIdByKeyId(keyId);
        model.addAttribute("spuAttrKey",spuAttrKey);
        model.addAttribute("integerList",integerList);
        model.addAttribute("list",categoryService.list());
        return "attr/update";
    }

    @RequestMapping("/save")
    public String save(SpuAttrKeyAddBo spuAttrKeyAddBo){
        boolean result = spuAttrKeyService.insertOne(spuAttrKeyAddBo);
        if (result){
            return "redirect:/index/success?message=add success";
        }else {
            return "redirect:/index/success?message=add error";
        }
    }

    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("list",categoryService.list());
        return "attr/add";
    }

    @RequestMapping("/admin")
    public String admin(SpuAttrKeySearchBo searchBo, PageBo pageBo, Model model){
        List<SpuAttrKey> keyList = spuAttrKeyService.listByBo(searchBo, pageBo);
        model.addAttribute("searchBo",searchBo);
        model.addAttribute("pageBo",pageBo);
        model.addAttribute("keyList",keyList);
        return "attr/admin";
    }
}
