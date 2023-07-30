package com.atstudy.service;

import com.atstudy.pojo.User;
import com.atstudy.pojo.bo.PageBo;
import com.atstudy.pojo.bo.UserBo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    /**
     * 通过查询条件查询客户信息
     * @param userBo
     * @param pageBo
     * @return
     */
    List<User> selectByUserBo(UserBo userBo, PageBo pageBo);
}
