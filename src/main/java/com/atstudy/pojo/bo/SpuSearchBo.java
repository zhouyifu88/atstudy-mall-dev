package com.atstudy.pojo.bo;

import lombok.Data;

@Data
public class SpuSearchBo {
    private Long spuId;
    private String spuName;
    private Byte spuStatus;
    private String spuBrandId;
    private Integer cateId;
}
