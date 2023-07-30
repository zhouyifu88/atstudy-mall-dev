package com.atstudy.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Sku {
    @TableId
    private Long skuId;
    private Long skuSpuId;
    private String skuName;
    private String skuSpuattr;
    private Double skuPrice;
    private Double skuOriginalprice;
    private Double skuCostprice;
    private Integer skuQuantity;
    private Integer sortno;
    private LocalDateTime createtime;
    private LocalDateTime updatetime;
}
