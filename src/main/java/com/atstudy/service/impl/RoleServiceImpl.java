package com.atstudy.service.impl;

import com.atstudy.mapper.RoleMapper;
import com.atstudy.mapper.RolePermissionMapper;
import com.atstudy.pojo.Role;
import com.atstudy.pojo.bo.PageBo;
import com.atstudy.service.RoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public List<Role> listAll() {
        List<Role> roles = roleMapper.selectList(new QueryWrapper<>());
        return roles;
    }

    @Override
    public List<Role> listByRolePageBo(Role role, PageBo pageBo) {
        //先查找到角色列表的总数
        long l = roleMapper.selectRoleCount(role);
        //将查找到的总查询数传给pageBo分页模型
        pageBo.setResultCount(l);
        List<Role> roleList = roleMapper.listByRolePageBo(role, pageBo);
        return roleList;
    }

    @Override
    public boolean existsRoleName(String name) {
        QueryWrapper<Role> wrapper = new QueryWrapper<>();
        wrapper.eq("role_name",name);
        Role role = roleMapper.selectOne(wrapper);
        return role != null;
    }

    @Transactional
    @Override
    public boolean insertRole(Integer[] idList, String roleName) {
        Long count = roleMapper.selectCount(new QueryWrapper<>());
        Role role = new Role();
        role.setRoleId((int) (count+1));
        role.setRoleName(roleName);
        int i = roleMapper.insert(role);
        int i1 = roleMapper.insertRolePermission(idList, role);
        return i >= 1 && i1 >= 1;
    }

    @Override
    public Role selectByRoleId(Integer roleId) {
        QueryWrapper<Role> wrapper = new QueryWrapper<>();
        wrapper.eq("role_id",roleId);
        Role role = roleMapper.selectOne(wrapper);
        return role;
    }

    @Transactional
    @Override
    public boolean updateRolePermission(Integer[] idList, Integer roleId, String roleName) {
        Role role = new Role();
        role.setRoleId(roleId);
        role.setRoleName(roleName);
        UpdateWrapper<Role> wrapper = new UpdateWrapper<>();
        wrapper.set("role_name",roleName).eq("role_id",roleId);
        //先更新角色表
        int i = roleMapper.update(role, wrapper);
        //删除原有角色权限
        Map<String,Object> map = new HashMap<>();
        map.put("role_id",roleId);
        int i1 = rolePermissionMapper.deleteByMap(map);
        //批量添加角色权限
        int i2 = rolePermissionMapper.batchInsertRolePermission(idList, roleId);
        return i >= 1 && i1 >= 1 && i2 >= 1;
    }

    @Transactional
    @Override
    public boolean deleteRolePermission(Integer roleId) {
        //先删除角色表
        Map<String,Object> map = new HashMap<>();
        map.put("role_id",roleId);
        int i = roleMapper.deleteByMap(map);
        //再删除角色权限
        int i1 = rolePermissionMapper.deleteByMap(map);
        return i >= 1 && i1 >= 1;
    }

    @Transactional
    @Override
    public boolean deleteBatchRolePermission(Integer[] idList) {
        //先批量删除角色表
        int i = roleMapper.deleteBatchRole(idList);
        //再批量删除角色权限
        int i1 = rolePermissionMapper.batchDeleteRolePermission(idList);
        return i >= 1 && i1 >= 1;
    }
}
