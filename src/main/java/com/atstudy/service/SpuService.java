package com.atstudy.service;

import com.atstudy.pojo.Spu;
import com.atstudy.pojo.SpuAttrKey;
import com.atstudy.pojo.bo.PageBo;
import com.atstudy.pojo.bo.SpuAddBo;
import com.atstudy.pojo.bo.SpuSearchBo;
import com.atstudy.pojo.bo.SpuUpdateBo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpuService {



    /**
     * 通过查询条件查询到spu列表
     * @return
     */
    List<Spu> listBySearchBo(SpuSearchBo spuSearchBo, PageBo pageBo);

    /**
     * 添加一条数据
     * @return
     */
    boolean insertOne(SpuAddBo spuAddBo);

    /**
     * 通过spuId查询spu数据
     * @return
     */
    Spu selectById(Long spuId);

    List<Integer> listCateIdBySpuId(Long spuId);

    boolean updateOne(SpuUpdateBo spuUpdateBo);

    boolean deleteOne(Long spuId);

    boolean deleteBatch(Long[] idList);

    List<Spu> list();
}
