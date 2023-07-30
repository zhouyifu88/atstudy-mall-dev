package com.atstudy.pojo.bo;

import com.atstudy.pojo.Category;
import com.atstudy.pojo.SpuAttrKey;
import com.atstudy.pojo.SpuAttrValue;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SkuUpdateBo {
    private Long skuId;
    private String skuName;
    private Double skuPrice;
    private Double skuOriginalprice;
    private Double skuCostprice;
    private Integer skuQuantity;
    private Long skuSpuId;

    private List<SpuAttrValue> valueList = new ArrayList<>();

    private List<SpuAttrKey> keyList = new ArrayList<>();
}
