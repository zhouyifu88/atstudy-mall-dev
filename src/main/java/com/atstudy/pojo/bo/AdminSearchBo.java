package com.atstudy.pojo.bo;

import lombok.Data;

@Data
public class AdminSearchBo {
    private Integer adminId;
    private String adminName;
    private String adminNickname;
    private Integer roleId;
}
