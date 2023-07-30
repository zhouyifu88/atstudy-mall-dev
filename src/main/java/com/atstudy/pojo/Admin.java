package com.atstudy.pojo;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
public class Admin implements UserDetails {

    @TableId
    private Integer adminId;
    private String adminName;
    private String adminPass;
    private String adminNickname;

    //一个用户可以拥有多个角色，所以用户类有角色列表
    private List<Role> roleList = new ArrayList<>();

    //一个用户可以拥有多个菜单，所以用户类有菜单列表
    private List<Menu> menuList = new ArrayList<>();

    //获取到授权列表，直接返回角色列表
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoleList();
    }

    @Override
    public String getPassword() {
        return getAdminPass();
    }

    @Override
    public String getUsername() {
        return getAdminName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
