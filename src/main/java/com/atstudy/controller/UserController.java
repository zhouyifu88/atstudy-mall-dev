package com.atstudy.controller;

import com.atstudy.pojo.User;
import com.atstudy.pojo.bo.PageBo;
import com.atstudy.pojo.bo.UserBo;
import com.atstudy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/admin")
    public String admin(UserBo userBo, PageBo pageBo, Model model){
        List<User> userList = userService.selectByUserBo(userBo, pageBo);
        model.addAttribute("pageBo",pageBo);
        model.addAttribute("userList",userList);
        model.addAttribute("userBo",userBo);
        return "user/admin";
    }
}
