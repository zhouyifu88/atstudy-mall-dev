package com.atstudy.controller;

import com.atstudy.pojo.Permission;
import com.atstudy.pojo.Role;
import com.atstudy.pojo.bo.PageBo;
import com.atstudy.pojo.vo.PermissionRoleVo;
import com.atstudy.service.PermissionRoleVoService;
import com.atstudy.service.PermissionService;
import com.atstudy.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/role")
public class RoleController {

    @Resource
    private RoleService roleService;

    @Resource
    private PermissionService permissionService;

    @Resource
    private PermissionRoleVoService permissionRoleVoService;

    @RequestMapping("/delete")
    public String delete(Integer[] idList,Integer roleId){
        boolean result;
        if (roleId == null){
            //接收到的是角色id列表
            result = roleService.deleteBatchRolePermission(idList);
        }else {
            //接收到的是单个角色id
            result = roleService.deleteRolePermission(roleId);
        }
        if (result){
            return "redirect:/index/success?message=delete success";
        }else {
            return "redirect:/index/success?message=delete error";
        }
    }

    @PostMapping("/alter")
    public String alter(Integer[] idList,Integer roleId,String roleName){
        boolean result = roleService.updateRolePermission(idList, roleId, roleName);
        if (result){
            return "redirect:/index/success?message=update success";
        }else {
            return "redirect:/index/success?message=update error";
        }
    }

    @RequestMapping("/update")
    public String update(Integer roleId,Model model){
        List<PermissionRoleVo> permissionRoleVos = permissionRoleVoService.listPerRoleVo(roleId);
        Role role = roleService.selectByRoleId(roleId);
        model.addAttribute("permissions",permissionRoleVos);
        model.addAttribute("role",role);
        return "role/update";
    }

    @PostMapping("/save")
    public String save(Integer[] idList,String roleName){
        log.info(Arrays.toString(idList));
        log.info(roleName.toString());
        boolean result = roleService.insertRole(idList, roleName);
        if (result){
            return "redirect:/index/success?message=save success";
        }else {
            return "redirect:/index/success?message=save error";
        }
    }

    @RequestMapping("/validate")
    @ResponseBody
    public String validate(String roleName){
        Boolean result = roleService.existsRoleName(roleName);
        System.out.println(result);
        return result.toString();
    }

    @RequestMapping("/add")
    public String add(Model model){
        List<Permission> permissions = permissionService.listPermission();
        model.addAttribute("permissions",permissions);
        return "role/add";
    }

    @RequestMapping("/admin")
    public String admin(Role role, PageBo pageBo, Model model){
        System.out.println(role);
        System.out.println(pageBo);
        List<Role> roleList = roleService.listByRolePageBo(role, pageBo);
        model.addAttribute("roleList",roleList);
        return "role/admin";
    }
}
