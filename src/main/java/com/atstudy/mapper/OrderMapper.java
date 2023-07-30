package com.atstudy.mapper;

import com.atstudy.pojo.Order;
import com.atstudy.pojo.bo.OrderBo;
import com.atstudy.pojo.bo.PageBo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
    /**
     * 通过条件查询订单总数
     * @return
     */
    Long countSelectByOrderBo(@Param("orderBo") OrderBo orderBo);

    /**
     * 通过条件查询订单列表
     * @param orderBo
     * @param pageBo
     * @return
     */
    List<Order> listByByOrderBo(@Param("orderBo")OrderBo orderBo,@Param("pageBo") PageBo pageBo);
}
