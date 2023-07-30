package com.atstudy.pojo.bo;

import lombok.Data;

@Data
public class CategoryUpdateBo {
    private Integer cateId;
    private String cateName;
    private Integer cateSort;
    private Integer cateParentid;
}
