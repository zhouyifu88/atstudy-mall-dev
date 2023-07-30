package com.atstudy.pojo;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class SpuAttrKey {
    private String keyId;
    private String keyName;
    private Byte keyIssku;
    private Byte keyIshigh;
    private LocalDateTime createtime;
    private LocalDateTime updatetime;

    //一个商品属性键可以有多个商品属性值
    private List<SpuAttrValue> attrValueList = new ArrayList<>();
}
