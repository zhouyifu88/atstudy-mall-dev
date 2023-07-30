package com.atstudy.pojo.bo;

import lombok.Data;

@Data
public class PageBo {
    private Long startIndex = 0L;           //起始索引
    private Long page = 1L;               //当前页码
    private Long pageSize = 10L;          //每页查询数量
    private Long pageCount;              //总页数（这个需要通过计算得到）
    private Long resultCount;               //总记录数

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
        setStartIndex((getPage()-1)*getPageSize());
    }

    public void setPage(Long page) {
        this.page = page;
        //设置起始索引
        setStartIndex((getPage()-1)*getPageSize());
    }

    public void setResultCount(Long resultCount) {
        this.resultCount = resultCount;
        //设置总页数
        setPageCount(getResultCount()%getPageSize()==0?getResultCount()/getPageSize():getResultCount()/getPageSize()+1);
    }

    public void setPageCount(Long pageCount) {
        this.pageCount = pageCount;
        //设置总页数的时候做边界控制
        if (getPage()>getPageCount()){
            setPage(getPageCount());
        }
        if (getPage()<1){
            setPage(1L);
        }
    }
}
