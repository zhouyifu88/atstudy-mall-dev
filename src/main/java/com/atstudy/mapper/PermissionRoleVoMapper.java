package com.atstudy.mapper;

import com.atstudy.pojo.vo.PermissionRoleVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PermissionRoleVoMapper extends BaseMapper<PermissionRoleVo> {
    List<PermissionRoleVo> selectPerRoleVo(@Param("roleId") Integer roleId);
}
