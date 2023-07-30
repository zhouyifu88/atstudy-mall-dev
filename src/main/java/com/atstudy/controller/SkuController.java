package com.atstudy.controller;

import com.atstudy.pojo.Sku;
import com.atstudy.pojo.SpuAttrKey;
import com.atstudy.pojo.bo.PageBo;
import com.atstudy.pojo.bo.SkuAddBo;
import com.atstudy.pojo.bo.SkuSearchBo;
import com.atstudy.pojo.bo.SkuUpdateBo;
import com.atstudy.service.SkuService;
import com.atstudy.service.SpuAttrKeyService;
import com.atstudy.service.SpuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/sku")
public class SkuController {
    @Resource
    private SkuService skuService;

    @Resource
    private SpuService spuService;

    @Resource
    private SpuAttrKeyService spuAttrKeyService;

    @RequestMapping("/delete")
    public String delete(Long skuId,Long[] idList){
        boolean result;
        if (skuId != null){
            result = skuService.deleteOne(skuId);
        }else {
            result = skuService.deleteBatch(idList);
        }
        if (result){
            return "redirect:/index/success?message=delete success";
        }else {
            return "redirect:/index/success?message=delete error";
        }
    }

    @RequestMapping("/alter")
    public String alter(SkuUpdateBo skuUpdateBo){
        boolean result = skuService.updateOne(skuUpdateBo);
        if (result){
            return "redirect:/index/success?message=update success";
        }else {
            return "redirect:/index/success?message=update error";
        }
    }

    @RequestMapping("/update")
    public String update(Long skuId,Model model){
        Sku sku = skuService.findById(skuId);
        model.addAttribute("spuList",spuService.list());
        model.addAttribute("sku",sku);
        return "sku/update";
    }

    @PostMapping("/save")
    public String save(SkuAddBo skuAddBo){
        boolean result = skuService.insertOne(skuAddBo);
        if (result){
            return "redirect:/index/success?message=save success";
        }else {
            return "redirect:/index/success?message=save error";
        }
    }

    @RequestMapping("/getKeyValue")
    @ResponseBody
    public Object getKeyValue(Long spuId){
        List<SpuAttrKey> keyList = spuAttrKeyService.getKeyValue(spuId);
        return keyList;
    }

    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("spuList",spuService.list());
        return "sku/add";
    }

    @RequestMapping("/admin")
    public String admin(SkuSearchBo searchBo, PageBo pageBo, Model model){
        model.addAttribute("searchBo",searchBo);
        model.addAttribute("pageBo",pageBo);
        List<Sku> skuList = skuService.listBySearchBo(searchBo, pageBo);
        model.addAttribute("skuList",skuList);
        return "sku/admin";
    }
}
