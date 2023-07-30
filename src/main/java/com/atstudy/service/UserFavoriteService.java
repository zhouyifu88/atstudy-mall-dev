package com.atstudy.service;

import com.atstudy.pojo.UserFavorite;
import com.atstudy.pojo.bo.PageBo;
import com.atstudy.pojo.bo.UserFavoriteBo;

import java.util.List;

public interface UserFavoriteService {

    List<UserFavorite> listByBo(UserFavoriteBo userFavoriteBo, PageBo pageBo);
}
