package com.atstudy.controller;

import com.atstudy.pojo.Admin;
import com.atstudy.pojo.Role;
import com.atstudy.pojo.bo.AdminAddBo;
import com.atstudy.pojo.bo.AdminSearchBo;
import com.atstudy.pojo.bo.AdminUpdateBo;
import com.atstudy.pojo.bo.PageBo;
import com.atstudy.service.AdminService;
import com.atstudy.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminService adminService;

    @Resource
    private RoleService roleService;

    @RequestMapping("/delete")
    public String delete(Integer adminId,Integer[] idList){
        boolean result;
        if (adminId == null){
            result = adminService.deleteBatchAdminIds(idList);
        }else {
            result = adminService.deleteAdminById(adminId);
        }
        if (result){
            return "redirect:/index/success?message=delete success";
        }else {
            return "redirect:/index/success?message=delete error";
        }
    }

    @PostMapping("/alter")
    public String alter(AdminUpdateBo adminUpdateBo){
        boolean result = adminService.updateAdmin(adminUpdateBo);
        if (result){
            return "redirect:/index/success?message=update success";
        }else {
            return "redirect:/index/success?message=update error";
        }
    }

    @RequestMapping("/update")
    public String update(Integer adminId,Model model){
        Admin admin = adminService.findByAdminId(adminId);
        model.addAttribute("admin",admin);
        model.addAttribute("roleList",roleService.listAll());
        return "admin/update";
    }

    @PostMapping("/save")
    public String save(AdminAddBo adminAddBo){
        boolean result = adminService.insertAdmin(adminAddBo);
        if (result){
            return "redirect:/index/success?message=save success";
        }else {
            return "redirect:/index/success?message=save error";
        }
    }

    @RequestMapping("/add")
    public String add(Model model){
        List<Role> roleList = roleService.listAll();
        model.addAttribute("roleList",roleList);
        return "admin/add";
    }

    @RequestMapping("/admin")
    public String admin(AdminSearchBo adminSearchBo, PageBo pageBo, Model model){
        //根据查询条件和分页条件查询员工列表
        List<Admin> admins = adminService.listByAdminSearchBo(adminSearchBo, pageBo);
        //将查询到的员工列表放入请求域中
        model.addAttribute("admins",admins);
        //将分页数据放入请求域中
        model.addAttribute("pageBo",pageBo);
        //将角色列表放入请求域
        model.addAttribute("roleList",roleService.listAll());
        //将筛选条件放入请求域，让筛选条件持久化
        model.addAttribute("adminSearchBo",adminSearchBo);
        return "admin/admin";
    }
}
