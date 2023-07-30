package com.atstudy.service;

import com.atstudy.pojo.Cart;
import com.atstudy.pojo.bo.CartBo;
import com.atstudy.pojo.bo.PageBo;

import java.util.List;

public interface CartService {
    /**
     * 根据条件查询预购列表
     * @param
     * @return
     */
    List<Cart> listByCartBo(CartBo cartBo, PageBo pageBo);
}
