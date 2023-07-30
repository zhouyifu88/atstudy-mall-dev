package com.atstudy.pojo.bo;

import com.atstudy.pojo.Role;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AdminUpdateBo {
    private Integer adminId;
    private String adminName;
    private String adminNickname;
    private List<Role> roleList = new ArrayList<>();
}
