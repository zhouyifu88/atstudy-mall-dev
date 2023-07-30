package com.atstudy.pojo.bo;

import lombok.Data;

@Data
public class CategoryBo {
    private Integer cateId;
    private String cateName;
    private Integer cateParentid;
}
