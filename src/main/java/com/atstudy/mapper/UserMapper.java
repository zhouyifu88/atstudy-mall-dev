package com.atstudy.mapper;

import com.atstudy.pojo.User;
import com.atstudy.pojo.bo.PageBo;
import com.atstudy.pojo.bo.UserBo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.tomcat.websocket.BackgroundProcess;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 通过筛选条件查询到客户列表
     * @param userBo
     * @return
     */
    List<User> selectByUserBo(@Param("userBo") UserBo userBo, @Param("pageBo") PageBo pageBo);

    /**
     * 通过查询条件查询客户的总记录数
     * @param userBo
     * @return
     */
    int countByUserBo(@Param("userBo") UserBo userBo);
}
