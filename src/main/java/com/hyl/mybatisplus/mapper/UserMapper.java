package com.hyl.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hyl.mybatisplus.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hyl.mybatisplus.query.BaseQuery;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 用户 Mapper 接口
 * </p>
 *
 * @author huangYl
 * @since 2019-01-10
 */
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user where name = #{name}")
    @ResultMap("BaseResultMap")
    User getByName(@Param("name") String name);

    User getByAge(int age);

    IPage<User> selectPageVo(@Param("page") Page<User> page,@Param("qo") BaseQuery qo);
}
