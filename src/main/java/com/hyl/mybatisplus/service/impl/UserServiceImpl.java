package com.hyl.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hyl.mybatisplus.entity.User;
import com.hyl.mybatisplus.mapper.UserMapper;
import com.hyl.mybatisplus.query.BaseQuery;
import com.hyl.mybatisplus.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author huangYl
 * @since 2019-01-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getByName(String name) {
        return userMapper.getByName(name);
    }

    @Override
    public User getByAge(int age) {
        return userMapper.getByAge(age);
    }

    @Override
    public IPage<User> getPageList(BaseQuery qo) {
        Page<User> page = new Page<>(qo.getPageNum(), qo.getPageSize());
        return userMapper.selectPageVo(page,qo);
    }


}
