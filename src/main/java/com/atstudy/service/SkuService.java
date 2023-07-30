package com.atstudy.service;

import com.atstudy.pojo.Sku;
import com.atstudy.pojo.bo.PageBo;
import com.atstudy.pojo.bo.SkuAddBo;
import com.atstudy.pojo.bo.SkuSearchBo;
import com.atstudy.pojo.bo.SkuUpdateBo;

import java.util.List;

public interface SkuService {
    List<Sku> listBySearchBo(SkuSearchBo searchBo, PageBo pageBo);

    boolean insertOne(SkuAddBo skuAddBo);

    Sku findById(Long skuId);

    boolean updateOne(SkuUpdateBo skuUpdateBo);

    boolean deleteOne(Long skuId);

    boolean deleteBatch(Long[] idList);
}
