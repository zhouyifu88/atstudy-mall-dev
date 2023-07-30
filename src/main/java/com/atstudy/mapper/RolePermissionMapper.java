package com.atstudy.mapper;

import com.atstudy.pojo.RolePermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RolePermissionMapper extends BaseMapper<RolePermission> {

    /**
     * 批量添加角色权限
     * @return
     */
    int batchInsertRolePermission(@Param("idList") Integer[] idList,@Param("roleId") Integer roleId);

    /**
     * 批量删除角色权限
     * @param idList
     * @return
     */
    int batchDeleteRolePermission(@Param("idList") Integer[] idList);
}
