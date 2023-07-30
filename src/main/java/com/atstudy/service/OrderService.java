package com.atstudy.service;

import com.atstudy.pojo.Order;
import com.atstudy.pojo.bo.OrderBo;
import com.atstudy.pojo.bo.PageBo;

import java.util.List;

public interface OrderService {
    List<Order> selectByOrderBo(OrderBo orderBo, PageBo pageBo);
}
