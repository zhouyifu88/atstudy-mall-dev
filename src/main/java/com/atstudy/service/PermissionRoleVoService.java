package com.atstudy.service;

import com.atstudy.pojo.vo.PermissionRoleVo;

import java.util.List;

public interface PermissionRoleVoService {
    List<PermissionRoleVo> listPerRoleVo(Integer roleId);
}
