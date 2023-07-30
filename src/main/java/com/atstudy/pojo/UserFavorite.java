package com.atstudy.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserFavorite {
    private Integer ufavorId;
    private String ufavorName;
    private String ufavorThumburl;
    private Double ufavorPrice;
    private LocalDateTime createtime;
    private LocalDateTime updatetime;
    private String ufavorSku;
    private Integer ufavorSpuId;
    private Integer ufavorUserId;
}
