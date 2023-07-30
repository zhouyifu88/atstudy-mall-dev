package com.atstudy.mapper;

import com.atstudy.pojo.Sku;
import com.atstudy.pojo.bo.PageBo;
import com.atstudy.pojo.bo.SkuSearchBo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SkuMapper extends BaseMapper<Sku> {

    int updateOne(@Param("sku") Sku sku);

    Sku findById(@Param("skuId") Long skuId);

    int insertOne(@Param("sku") Sku sku);

    List<Sku> listBySearchBo(@Param("searchBo") SkuSearchBo searchBo,@Param("pageBo") PageBo pageBo);

    Long countBySearchBo(@Param("searchBo")SkuSearchBo searchBo);
}
