package com.atstudy.mapper;

import com.atstudy.pojo.SpuAttrKey;
import com.atstudy.pojo.bo.PageBo;
import com.atstudy.pojo.bo.SpuAttrKeySearchBo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SpuAttrKeyMapper extends BaseMapper<SpuAttrKey> {
    /**
     * 通过筛选条件查询商品键列表
     * @param searchBo
     * @param pageBo
     * @return
     */
    List<SpuAttrKey> listByBo(@Param("searchBo") SpuAttrKeySearchBo searchBo,@Param("pageBo") PageBo pageBo);

    /**
     * 通过筛选条件查询商品键总查询数
     * @param searchBo
     * @return
     */
    int countByBo(@Param("searchBo")SpuAttrKeySearchBo searchBo);

    /**
     * 添加一条属性键数据
     * @return
     */
    int insertOne(@Param("spuAttrKey") SpuAttrKey spuAttrKey);

    /**
     * 通过keyId查询带有属性值列表的属性键列表
     * @param keyId
     * @return
     */
    SpuAttrKey listById(@Param("keyId") String keyId);

    /**
     * 修改属性键表数据
     * @param spuAttrKey
     * @return
     */
    int updateByBo(@Param("spuAttrKey") SpuAttrKey spuAttrKey);

    /**
     * 删除一个
     * @return
     */
    int deleteOne(@Param("keyId") String keyId);

    /**
     * 删除多个
     * @return
     */
    int deleteBatchIds(@Param("idList") String[] idList);

    List<SpuAttrKey> getKeyValue(@Param("spuId") Long spuId);
}
