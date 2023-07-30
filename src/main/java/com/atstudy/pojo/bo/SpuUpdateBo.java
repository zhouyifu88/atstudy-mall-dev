package com.atstudy.pojo.bo;

import com.atstudy.pojo.Category;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SpuUpdateBo {
    private Long spuId;
    private String spuName;
    private String spuTitle;
    private String spuIntroduction;
    private Byte spuStatus;
    private String spuBrandId;
    private List<Category> cateList = new ArrayList<>();
}
