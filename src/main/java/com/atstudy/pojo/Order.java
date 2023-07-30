package com.atstudy.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Order {
    private Integer id;
    private String orderNo;
    private Integer orderStatus;
    private Double orderSpuamount;
    private Double orderExpressfee;
    private Double orderTotalamount;
    private Double orderDiscountamount;
    private Double orderPayamount;
    private Integer orderPaymode;
    private Integer orderPayplatform;
    private String orderIpaddress;
    private String orderPaymentno;
    private String orderRemark;
    private LocalDateTime createtime;
    private LocalDateTime updatetime;
    private Integer orderUserId;
}
