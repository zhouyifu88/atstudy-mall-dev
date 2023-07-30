package com.atstudy.service.impl;

import com.atstudy.mapper.AdminMapper;
import com.atstudy.mapper.AdminRoleMapper;
import com.atstudy.pojo.Admin;
import com.atstudy.pojo.Role;
import com.atstudy.pojo.bo.AdminAddBo;
import com.atstudy.pojo.bo.AdminSearchBo;
import com.atstudy.pojo.bo.AdminUpdateBo;
import com.atstudy.pojo.bo.PageBo;
import com.atstudy.service.AdminService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Resource
    private AdminRoleMapper adminRoleMapper;

    //通过用户名获取到用户对象
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminMapper.findByName(username);
        //如果用户名不存在则报错
        if (admin == null){
            throw new UsernameNotFoundException("账户名或者密码错误，请重新输入");
        }
        return admin;
    }

    @Override
    public List<Admin> listByAdminSearchBo(AdminSearchBo adminSearchBo, PageBo pageBo) {
        //先用查询条件查询出总记录数
        Long count = adminMapper.findResultCountByAdminSearchBo(adminSearchBo);
        //然后将总记录数赋值给分页模型
        pageBo.setResultCount(count);
        //根据查询条件和分页条件查询员工列表
        List<Admin> admins = adminMapper.listByAdminBo(adminSearchBo, pageBo);
        return admins;
    }

    @Transactional
    @Override
    public boolean insertAdmin(AdminAddBo adminAddBo) {
        //向添加的数据中加入密码
        adminAddBo.setAdminPass(new BCryptPasswordEncoder().encode("abc123"));
        //先添加用户表
        int insertAdmin = adminMapper.insertAdmin(adminAddBo);
        //再添加用户角色表
        int insertAdminRole = adminMapper.insertAdminRole(adminAddBo);
        return insertAdminRole >= 1 && insertAdmin >= 1;
    }

    @Override
    public Admin findByAdminId(Integer id) {
        Admin admin = adminMapper.findByAdminId(id);
        return admin;
    }

    @Transactional
    @Override
    public boolean updateAdmin(AdminUpdateBo adminUpdateBo) {
        //修改员工信息
        int i = adminMapper.updateAdmin(adminUpdateBo);
        Integer adminId = adminUpdateBo.getAdminId();
        //删除原有的员工角色表中的对应信息
        int i1 = adminRoleMapper.deleteByAdminId(adminId);
        //添加新的员工角色关系信息
        int i2 = adminRoleMapper.batchInsert(adminUpdateBo);
        return i >= 1 && i1 >= 1 && i2 >= 1;
    }

    @Transactional
    @Override
    public boolean deleteAdminById(Integer id) {
        //先删除用户表
        int i = adminMapper.deleteById(id);
        //再删除用户角色关系表
        Map<String,Object> map = new HashMap<>();
        map.put("admin_id",id);
        int i1 = adminRoleMapper.deleteByMap(map);
        return i >= 1 && i1 >= 1;
    }

    @Transactional
    @Override
    public boolean deleteBatchAdminIds(Integer[] idList) {
        //先删除用户
        int i = adminMapper.deleteBatchIds(Arrays.asList(idList));
        //再删除用户关系表，因为admin_role表没有主键，无法使用mybatisPlus自带的批量删除方法
        int i1 = adminRoleMapper.deleteBatchAdminIds(idList);
        return i >= 1 && i1 >= 1;
    }
}
