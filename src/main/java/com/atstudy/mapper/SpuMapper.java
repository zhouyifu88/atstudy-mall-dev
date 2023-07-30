package com.atstudy.mapper;

import com.atstudy.pojo.Category;
import com.atstudy.pojo.Spu;
import com.atstudy.pojo.SpuAttrKey;
import com.atstudy.pojo.bo.PageBo;
import com.atstudy.pojo.bo.SpuSearchBo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SpuMapper extends BaseMapper<Spu> {

    List<Spu> list();

    int deleteBatchCateSpuIds(@Param("idList") Long[] idList);

    int deleteBatchSpuIds(@Param("idList") Long[] idList);

    int deleteBySpuId(@Param("spuId") Long spuId);

    int deleteCateSpuBySpuId(@Param("spuId") Long spuId);

    int updateOne(@Param("spu") Spu spu);

    List<Integer> listCateIdBySpuId(@Param("spuId") Long spuId);
    /**
     * 通过spuId查询spu数据
     * @return
     */
    Spu selectById(@Param("spuId") Long spuId);
    /**
     * 新增商品分类表数据
     * @return
     */
    int insertCateSpu(@Param("spuId") Long spuId,@Param("cateList") List<Category> cateList);
    /**
     * 插入一条数据
     * @return
     */
    int insertOne(@Param("spu") Spu spu);

    /**
     * 通过查询条件和分页条件查询spu列表
     * @return
     */
    List<Spu> listBySearchBo(@Param("spuSearchBo") SpuSearchBo spuSearchBo,@Param("pageBo") PageBo pageBo);

    /**
     * 通过查询条件查询到的总查询数
     * @return
     */
    Long countBySearchBo(@Param("spuSearchBo") SpuSearchBo spuSearchBo);
}
