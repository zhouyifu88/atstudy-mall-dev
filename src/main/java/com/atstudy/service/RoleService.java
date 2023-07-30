package com.atstudy.service;

import com.atstudy.pojo.Role;
import com.atstudy.pojo.bo.PageBo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleService {
    /**
     * 查询出所有的角色
     * @return
     */
    List<Role> listAll();

    /**
     * 通过查询条件查询到角色列表
     * @return
     */
    List<Role> listByRolePageBo(Role role,PageBo pageBo);

    /**
     * 通过角色名查看该角色是否存在
     * @param name
     * @return
     */
    boolean existsRoleName(String name);

    /**
     * 添加角色
     * @return
     */
    boolean insertRole(Integer[] idList,String roleName);

    /**
     * 根据roleId查询role类型
     * @return
     */
    Role selectByRoleId(Integer roleId);

    /**
     * 更新角色表及其权限
     * @return
     */
    boolean updateRolePermission(Integer[] idList,Integer roleId,String roleName);

    /**
     * 删除单个角色及其权限
     * @return
     */
    boolean deleteRolePermission(Integer roleId);

    /**
     * 批量删除角色及其权限
     * @param idList
     * @return
     */
    boolean deleteBatchRolePermission(Integer[] idList);
}
