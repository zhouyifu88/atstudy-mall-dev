package com.atstudy.pojo;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

/**
 * 角色类
 */
@Data
public class Role implements GrantedAuthority {

    @TableId
    private Integer roleId;
    private String roleName;

    //获取授权名称方法，直接返回角色名称就行
    @Override
    public String getAuthority() {
        return getRoleName();
    }
}
