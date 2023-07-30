package com.atstudy.controller;

import com.atstudy.pojo.Cart;
import com.atstudy.pojo.bo.CartBo;
import com.atstudy.pojo.bo.PageBo;
import com.atstudy.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Resource
    private CartService cartService;

    @RequestMapping("/admin")
    public String admin(CartBo cartBo, PageBo pageBo, Model model){
        List<Cart> cartList = cartService.listByCartBo(cartBo, pageBo);
        model.addAttribute("cartBo",cartBo);
        model.addAttribute("cartList",cartList);
        model.addAttribute("pageBo",pageBo);
        return "cart/admin";
    }
}
