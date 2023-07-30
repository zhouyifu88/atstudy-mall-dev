package com.atstudy.service.impl;

import com.atstudy.mapper.PermissionMapper;
import com.atstudy.pojo.Permission;
import com.atstudy.service.PermissionService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> listPermission() {
        List<Permission> permissions = permissionMapper.selectList(new QueryWrapper<Permission>());
        return permissions;
    }
}
