package com.atstudy.pojo.bo;

import com.atstudy.pojo.SpuAttrValue;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SpuAttrKeyAddBo {
    private String keyName;
    private Byte keyIssku;
    private Byte keyIshigh;
    private List<SpuAttrValue> attrValueList = new ArrayList<>();
    private Integer[] idList;
}
