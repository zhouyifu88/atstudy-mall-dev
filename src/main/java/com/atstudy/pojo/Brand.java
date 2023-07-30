package com.atstudy.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Brand {
    private String brandId;
    private String brandName;
    private String brandIntroduction;
    private String brandLogourl;
    private Integer sortno;
    private LocalDateTime createtime;
    private LocalDateTime updatetime;
}
