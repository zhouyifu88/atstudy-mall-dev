package com.atstudy.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Category {
    @TableId
    private Integer cateId;
    private String cateName;
    private Integer cateSort;
    private LocalDate createtime;
    private LocalDate updatetime;
    private String cateChannel;
    private Integer cateParentid;

    //父类分类
    private Category category;
}
