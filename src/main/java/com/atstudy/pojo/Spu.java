package com.atstudy.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Spu {
    private Long spuId;
    private String spuName;
    private String spuTitle;
    private String spuIntroduction;
    private String spuUnit;
    private Byte spuSketchtype;
    private String spuSketch;
    private String spuSpecs;
    private Byte spuSkutype;
    private Byte spuStatus;
    private LocalDateTime createtime;
    private LocalDateTime updatetime;
    private String spuBrandId;

    private Brand brand;
}
