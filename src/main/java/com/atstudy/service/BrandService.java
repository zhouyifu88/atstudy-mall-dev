package com.atstudy.service;

import com.atstudy.pojo.Brand;
import com.atstudy.pojo.bo.BrandSearchBo;
import com.atstudy.pojo.bo.PageBo;

import java.util.List;

public interface BrandService {
    /**
     * 查询出品牌列表
     * @return
     */
    List<Brand> list();
    /**
     * 通过条件查询品牌
     * @param searchBo
     * @param pageBo
     * @return
     */
    List<Brand> listByBo(BrandSearchBo searchBo, PageBo pageBo);

    /**
     * 删除单个品牌
     * @return
     */
    boolean deleteOne(String brandId);

    /**
     * 批量删除品牌
     * @return
     */
    boolean deleteList(String[] idList);
}
