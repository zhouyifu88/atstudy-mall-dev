package com.atstudy.mapper;

import com.atstudy.pojo.SpuAttrValue;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SpuAttrValueMapper extends BaseMapper<SpuAttrValue> {

    /**
     * 通过商品键的id查询商品值列表
     * @param keyId
     * @return
     */
    List<SpuAttrValue> listByKeyId(@Param("keyId") String keyId);

    /**
     * 批量添加属性值数据
     * @return
     */
    int insertBatchValue(@Param("valueList") List<SpuAttrValue> valueList);

    /**
     * 批量删除属性值表数据
     * @return
     */
    int deleteBatchIds(@Param("idList") String[] idList);
}
