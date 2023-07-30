package com.atstudy.pojo.bo;

import lombok.Data;

@Data
public class OrderBo {
    private Integer id;
    private String orderNo;
    private Integer orderStatus;
    private Integer orderUserId;
}
