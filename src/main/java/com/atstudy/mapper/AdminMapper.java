package com.atstudy.mapper;

import com.atstudy.pojo.Admin;
import com.atstudy.pojo.bo.AdminAddBo;
import com.atstudy.pojo.bo.AdminSearchBo;
import com.atstudy.pojo.bo.AdminUpdateBo;
import com.atstudy.pojo.bo.PageBo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminMapper extends BaseMapper<Admin> {
    /**
     * 根据用户名查询用户对象
     * @param adminName
     * @return
     */
    Admin findByName(@Param("adminName") String adminName);

    /**
     * 根据筛选条件查询出总记录数
     * @param adminSearchBo
     * @return
     */
    Long findResultCountByAdminSearchBo(@Param("adminSearchBo") AdminSearchBo adminSearchBo);

    /**
     * 根据筛选条件和分页条件查询出员工列表
     * @param adminSearchBo
     * @param pageBo
     * @return
     */
    List<Admin> listByAdminBo(@Param("adminSearchBo") AdminSearchBo adminSearchBo,@Param("pageBo") PageBo pageBo);

    /**
     * 向用户角色表添加数据
     * @return
     */
    int insertAdminRole(@Param("adminAddBo") AdminAddBo adminAddBo);

    /**
     * 向用户表添加数据
     * @param adminAddBo
     * @return
     */
    int insertAdmin(@Param("adminAddBo") AdminAddBo adminAddBo);

    /**
     * 通过id查询用户
     * @param id
     * @return
     */
    Admin findByAdminId(@Param("id") Integer id);

    /**
     * 修改员工信息
     * @return
     */
    int updateAdmin(@Param("adminUpdateBo") AdminUpdateBo adminUpdateBo);

}
