package com.atstudy.service;

import com.atstudy.pojo.SpuAttrKey;
import com.atstudy.pojo.bo.PageBo;
import com.atstudy.pojo.bo.SpuAttrKeyAddBo;
import com.atstudy.pojo.bo.SpuAttrKeySearchBo;
import com.atstudy.pojo.bo.SpuAttrUpdateBo;

import java.util.List;

public interface SpuAttrKeyService {
    /**
     * 通过筛选条件查询商品键列表
     * @param searchBo
     * @param pageBo
     * @return
     */
    List<SpuAttrKey> listByBo(SpuAttrKeySearchBo searchBo, PageBo pageBo);

    /**
     * 添加一条属性键参数
     * @return
     */
    boolean insertOne(SpuAttrKeyAddBo spuAttrKeyAddBo);

    /**
     * 通过keyId查询带有属性值列表的属性键列表
     * @param keyId
     * @return
     */
    SpuAttrKey listById(String keyId);

    /**
     * 通过属性键id查询到对应的分类列表
     * @param keyId
     * @return
     */
    List<Integer> listCateIdByKeyId(String keyId);

    /**
     * 修改属性键通过updateBo
     * @return
     */
    boolean updateByBo(SpuAttrUpdateBo spuAttrUpdateBo);

    /**
     * 删除一条数据
     * @return
     */
    boolean deleteOne(String keyId);

    /**
     * 删除多条数据
     * @return
     */
    boolean deleteBatchIds(String[] idList);

    List<SpuAttrKey> getKeyValue(Long spuId);
}
