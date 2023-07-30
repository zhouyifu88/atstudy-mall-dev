package com.atstudy.mapper;

import com.atstudy.pojo.Category;
import com.atstudy.pojo.bo.CategoryAddBo;
import com.atstudy.pojo.bo.CategoryBo;
import com.atstudy.pojo.bo.PageBo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

    /**
     * 通过条件查询分类列表
     * @param categoryBo
     * @param pageBo
     * @return
     */
    List<Category> listByCategoryBo(@Param("categoryBo")CategoryBo categoryBo,@Param("pageBo") PageBo pageBo);

    /**
     * 通过条件查询分类总数
     * @param categoryBo
     * @return
     */
    long countByCategoryBo(@Param("categoryBo") CategoryBo categoryBo);

    /**
     * 通过分类id查询分类
     * @param cateId
     * @return
     */
    Category selectByCateId(Integer cateId);

    /**
     * 直接查询出分类列表
     * @return
     */
    List<Category> list();

    /**
     * 通过分类名称查询
     * @param cateName
     * @return
     */
    int selectByCateName(@Param("cateName") String cateName);

    /**
     * 通过添加信息添加分类
     * @param
     * @return
     */
    int insertByCategory(@Param("category") Category category);

    /**
     * 通过分类id查询单条分类数据
     * @return
     */
    Category findByCateId(@Param("cateId") String cateId);

    /**
     * 根据Category修改分类
     * @return
     */
    int updateByCategory(@Param("category") Category category);
}
