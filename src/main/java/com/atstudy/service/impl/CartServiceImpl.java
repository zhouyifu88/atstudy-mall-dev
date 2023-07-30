package com.atstudy.service.impl;

import com.atstudy.mapper.CartMapper;
import com.atstudy.pojo.Cart;
import com.atstudy.pojo.bo.CartBo;
import com.atstudy.pojo.bo.PageBo;
import com.atstudy.service.CartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Resource
    private CartMapper cartMapper;

    @Override
    public List<Cart> listByCartBo(CartBo cartBo, PageBo pageBo) {
        Long count = cartMapper.countByCartBo(cartBo);
        pageBo.setResultCount(count);
        List<Cart> carts = cartMapper.listByCartBo(cartBo, pageBo);
        return carts;
    }
}
