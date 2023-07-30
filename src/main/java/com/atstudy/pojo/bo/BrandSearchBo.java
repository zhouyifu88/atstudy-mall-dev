package com.atstudy.pojo.bo;

import lombok.Data;

@Data
public class BrandSearchBo {
    private String brandId;
    private String brandName;
    private Integer sortno;
    private Integer categoryId;
}
