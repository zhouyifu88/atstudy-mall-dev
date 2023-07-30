package com.atstudy.service.impl;

import com.atstudy.mapper.PermissionRoleVoMapper;
import com.atstudy.pojo.vo.PermissionRoleVo;
import com.atstudy.service.PermissionRoleVoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PermissionRoleVoServiceImpl implements PermissionRoleVoService {

    @Resource
    private PermissionRoleVoMapper permissionRoleVoMapper;

    @Override
    public List<PermissionRoleVo> listPerRoleVo(Integer roleId) {
        List<PermissionRoleVo> permissionRoleVos = permissionRoleVoMapper.selectPerRoleVo(roleId);
        return permissionRoleVos;
    }
}
