package com.atstudy.controller;

import com.atstudy.pojo.UserFavorite;
import com.atstudy.pojo.bo.PageBo;
import com.atstudy.pojo.bo.UserFavoriteBo;
import com.atstudy.service.UserFavoriteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/favorite")
public class FavoriteController {

    @Resource
    private UserFavoriteService userFavoriteService;

    @RequestMapping("/admin")
    public String admin(UserFavoriteBo userFavoriteBo, PageBo pageBo, Model model){
        List<UserFavorite> userFavorites = userFavoriteService.listByBo(userFavoriteBo, pageBo);
        model.addAttribute("userFavorites",userFavorites);
        model.addAttribute("pageBo",pageBo);
        model.addAttribute("userFavoriteBo",userFavoriteBo);
        return "favorite/admin";
    }
}
