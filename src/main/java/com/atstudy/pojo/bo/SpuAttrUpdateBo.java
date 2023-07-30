package com.atstudy.pojo.bo;

import com.atstudy.pojo.SpuAttrValue;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SpuAttrUpdateBo {
    private String keyId;
    private String keyName;
    private Byte keyIssku;
    private Byte keyIshigh;
    //一个商品属性键可以有多个商品属性值
    private List<SpuAttrValue> attrValueList = new ArrayList<>();
    private Integer[] idList;
}
