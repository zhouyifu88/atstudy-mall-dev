package com.atstudy.controller;

import com.atstudy.pojo.Order;
import com.atstudy.pojo.bo.OrderBo;
import com.atstudy.pojo.bo.PageBo;
import com.atstudy.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/userorder")
public class UserOrderController {

    @Resource
    private OrderService orderService;

    @RequestMapping("/admin")
    public String admin(OrderBo orderBo,PageBo pageBo, Model model){
        List<Order> orderList = orderService.selectByOrderBo(orderBo, pageBo);
        model.addAttribute("orderList",orderList);
        model.addAttribute("orderBo",orderBo);
        model.addAttribute("model",model);
        return "userorder/admin";
    }
}
