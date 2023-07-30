package com.atstudy.service;

import com.atstudy.pojo.Admin;
import com.atstudy.pojo.bo.AdminAddBo;
import com.atstudy.pojo.bo.AdminSearchBo;
import com.atstudy.pojo.bo.AdminUpdateBo;
import com.atstudy.pojo.bo.PageBo;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AdminService extends UserDetailsService {
    /**
     * 根据筛选条件和分页条件查询出满足条件的员工列表
     */
    List<Admin> listByAdminSearchBo(AdminSearchBo adminSearchBo, PageBo pageBo);

    /**
     * 向用户表中添加数据
     * @return
     */
    boolean insertAdmin(AdminAddBo adminAddBo);

    /**
     * 通过id查询Admin实体类
     * @param id
     * @return
     */
    Admin findByAdminId(Integer id);

    /**
     * 修改员工信息
     * @param adminUpdateBo
     * @return
     */
    boolean updateAdmin(AdminUpdateBo adminUpdateBo);

    /**
     * 通过单个id删除用户
     * @param id
     * @return
     */
    boolean deleteAdminById(Integer id);

    /**
     * 通过id数组批量删除用户
     * @return
     */
    boolean deleteBatchAdminIds(Integer[] idList);
}
