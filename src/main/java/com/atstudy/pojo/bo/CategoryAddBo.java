package com.atstudy.pojo.bo;

import lombok.Data;

@Data
public class CategoryAddBo {
    private String cateName;
    private Integer cateSort;
    private Integer cateParentid;
}
