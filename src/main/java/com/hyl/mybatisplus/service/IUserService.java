package com.hyl.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hyl.mybatisplus.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hyl.mybatisplus.query.BaseQuery;

import java.util.List;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author huangYl
 * @since 2019-01-10
 */
public interface IUserService extends IService<User> {

    User getByName(String name);

    User getByAge(int age);

    IPage<User> getPageList(BaseQuery qo);
}
