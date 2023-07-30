package com.atstudy.mapper;

import com.atstudy.pojo.Cart;
import com.atstudy.pojo.bo.CartBo;
import com.atstudy.pojo.bo.PageBo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CartMapper extends BaseMapper<Cart> {

    /**
     * 根据条件查询预购数量
     * @return
     */
    Long countByCartBo(@Param("cartBo") CartBo cartBo);

    /**
     * 根据条件查询预购列表
     * @param cartBo
     * @param pageBo
     * @return
     */
    List<Cart> listByCartBo(@Param("cartBo") CartBo cartBo,@Param("pageBo") PageBo pageBo);
}
