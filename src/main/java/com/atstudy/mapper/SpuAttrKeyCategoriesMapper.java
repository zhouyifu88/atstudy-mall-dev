package com.atstudy.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SpuAttrKeyCategoriesMapper {

    int insertOne(@Param("keyId") String keyId,@Param("cateId") Integer cateId);

    List<Integer> listCateIdByKeyId(@Param("keyId") String keyId);

    int deleteById(@Param("id") String id);

    int deleteBatchIds(@Param("idList") String[] idList);
}
