package com.hyl.mybatisplus.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hyl.mybatisplus.entity.User;
import com.hyl.mybatisplus.query.BaseQuery;
import com.hyl.mybatisplus.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author huangYl
 * @since 2019-01-10
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/{id}")
    public User get(@PathVariable("id") Long id) {
        User user = userService.getById(id);
        System.out.println(user);
        return user;
    }

    @GetMapping("/list")
    public List<User> get() {
//        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.lambda().eq(User::getName, "hyl");
       return userService.list(null);
//        return userService
    }

    @PostMapping
    public String save(@RequestBody User user){
        userService.save(user);
        return "suc";
    }

    @GetMapping("/name")
    public User get(String name) {
        return userService.getByName(name);
//        return userService
    }

    @GetMapping("/age")
    public User get(int age) {
        return userService.getByAge(age);
//        return userService
    }

    @GetMapping("/page")
    public IPage<User> getPage(@RequestBody BaseQuery qo) {
        return userService.getPageList(qo);
//        return userService
    }

}

