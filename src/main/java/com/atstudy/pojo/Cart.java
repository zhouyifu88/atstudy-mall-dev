package com.atstudy.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Cart {
    private Integer carId;
    private Integer cartUserid;
    private Integer LongCartSpuid;
    private Integer cartSkuid;
    private String cartName;
    private String cartThumburl;
    private Double cartPrice;
    private Integer cartCount;
    private Byte cartChecked;
    private LocalDateTime createtime;
    private LocalDateTime updatetime;
    private String cartSku;
}
