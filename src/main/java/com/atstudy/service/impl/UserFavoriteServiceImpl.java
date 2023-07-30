package com.atstudy.service.impl;

import com.atstudy.mapper.UserFavoriteMapper;
import com.atstudy.pojo.UserFavorite;
import com.atstudy.pojo.bo.PageBo;
import com.atstudy.pojo.bo.UserFavoriteBo;
import com.atstudy.service.UserFavoriteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserFavoriteServiceImpl implements UserFavoriteService {

    @Resource
    private UserFavoriteMapper userFavoriteMapper;

    @Override
    public List<UserFavorite> listByBo(UserFavoriteBo userFavoriteBo, PageBo pageBo) {
        Long result = userFavoriteMapper.countByBo(userFavoriteBo);
        pageBo.setResultCount(result);
        List<UserFavorite> userFavorites = userFavoriteMapper.listByBo(userFavoriteBo, pageBo);
        return userFavorites;
    }
}
