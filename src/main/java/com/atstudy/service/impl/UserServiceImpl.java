package com.atstudy.service.impl;

import com.atstudy.mapper.UserMapper;
import com.atstudy.pojo.User;
import com.atstudy.pojo.bo.PageBo;
import com.atstudy.pojo.bo.UserBo;
import com.atstudy.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> selectByUserBo(UserBo userBo, PageBo pageBo) {
        //先查询出总记录数
        int count = userMapper.countByUserBo(userBo);
        //将总记录数赋值给分页模型
        pageBo.setResultCount((long) count);
        List<User> user = userMapper.selectByUserBo(userBo, pageBo);
        return user;
    }
}
