package com.atstudy.pojo;

import lombok.Data;

@Data
public class Menu {
    private Integer menuId;
    private String menuName;
    private String menuUrl;
    private Integer pid;
}
