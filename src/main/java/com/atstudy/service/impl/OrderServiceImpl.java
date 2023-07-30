package com.atstudy.service.impl;

import com.atstudy.mapper.OrderMapper;
import com.atstudy.pojo.Order;
import com.atstudy.pojo.bo.OrderBo;
import com.atstudy.pojo.bo.PageBo;
import com.atstudy.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Override
    public List<Order> selectByOrderBo(OrderBo orderBo, PageBo pageBo) {
        //首先通过查询订单总数
        Long count = orderMapper.countSelectByOrderBo(orderBo);
        //然后将查询到的总查询数赋值给分页模型
        pageBo.setResultCount(count);
        //然后通过条件查询订单列表
        List<Order> orderList = orderMapper.listByByOrderBo(orderBo, pageBo);
        return orderList;
    }
}
