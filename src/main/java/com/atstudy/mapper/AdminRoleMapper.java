package com.atstudy.mapper;

import com.atstudy.pojo.AdminRole;
import com.atstudy.pojo.bo.AdminUpdateBo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminRoleMapper extends BaseMapper<AdminRole> {
    /**
     * 根据admin_id删除用户角色关系
     * @param id
     * @return
     */
    int deleteByAdminId(@Param("id") Integer id);

    /**
     * 批量添加
     * @return
     */
    int batchInsert(@Param("adminUpdateBo") AdminUpdateBo adminUpdateBo);

    /**
     * 通过id数组删除用户角色数据
     * @return
     */
    int deleteBatchAdminIds(Integer[] ids);
}
