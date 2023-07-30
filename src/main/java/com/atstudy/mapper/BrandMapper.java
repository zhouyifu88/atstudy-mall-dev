package com.atstudy.mapper;

import com.atstudy.pojo.Brand;
import com.atstudy.pojo.bo.BrandSearchBo;
import com.atstudy.pojo.bo.PageBo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BrandMapper extends BaseMapper<Brand> {
    /**
     * 查询出品牌列表
     * @return
     */
    List<Brand> list();
    /**
     * 通过brandId查询Brand数据
     * @return
     */
    Brand selectByBrandId(@Param("brandId") String brandId);
    /**
     * 通过条件查询品牌
     * @param searchBo
     * @param pageBo
     * @return
     */
    List<Brand> listByBo(@Param("searchBo") BrandSearchBo searchBo,@Param("pageBo") PageBo pageBo);

    /**
     * 通过条件查询总数
     * @param searchBo
     * @return
     */
    int countByBo(@Param("searchBo") BrandSearchBo searchBo);

    int deleteId(@Param("brandId") String brandId);

    int deleteIds(@Param("idList") String[] idList);
}

