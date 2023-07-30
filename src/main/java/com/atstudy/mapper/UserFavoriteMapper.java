package com.atstudy.mapper;

import com.atstudy.pojo.UserFavorite;
import com.atstudy.pojo.bo.PageBo;
import com.atstudy.pojo.bo.UserFavoriteBo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserFavoriteMapper extends BaseMapper<UserFavorite> {
    /**
     * 按条件查询收藏总数
     * @param userFavoriteBo
     * @return
     */
    Long countByBo(@Param("userFavoriteBo") UserFavoriteBo userFavoriteBo);

    /**
     * 按条件查询收藏列表
     * @param userFavoriteBo
     * @param pageBo
     * @return
     */
    List<UserFavorite> listByBo(@Param("userFavoriteBo") UserFavoriteBo userFavoriteBo,@Param("pageBo") PageBo pageBo);
}
