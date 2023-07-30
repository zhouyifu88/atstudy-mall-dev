package com.atstudy.mapper;

import com.atstudy.pojo.Role;
import com.atstudy.pojo.bo.PageBo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    /**
     * 根据用户id查询角色列表
     * @param adminId
     * @return
     */
    List<Role> listByAdminId(@Param("adminId") Integer adminId);

    /**
     * 根据url查询角色列表
     * @param url
     * @return
     */
    List<Role> listByUrl(@Param("url") String url);

    /**
     * 根据条件查询角色列表
     * @param role
     * @param pageBo
     * @return
     */
    List<Role> listByRolePageBo(@Param("role") Role role,@Param("pageBo") PageBo pageBo);

    /**
     * 查找角色数量
     * @return
     */
    long selectRoleCount(@Param("role") Role role);

    /**
     * 添加角色权限表
     * @return
     */
    int insertRolePermission(@Param("idList") Integer[] idList,@Param("role") Role role);

    /**
     * 批量删除角色
     * @param idList
     * @return
     */
    int deleteBatchRole(@Param("idList") Integer[] idList);
}
