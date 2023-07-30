package com.atstudy.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SpuAttrValue {
    private Long id;
    private String valueName;
    private LocalDateTime createtime;
    private LocalDateTime updatetime;
    private String valueAttrKeyId;
}
