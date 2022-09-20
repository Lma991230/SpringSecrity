package com.exampl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.exampl.domain.LoginUser;
import com.exampl.domain.User;
import com.exampl.mapper.UserMapper;
import io.netty.util.internal.ObjectUtil;
import kotlin.jvm.internal.Lambda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceDetailsImpl implements UserDetailsService {

    @Autowired
    private UserMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //查询用户信息
        LambdaQueryWrapper<User>  queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName, userName);
        User user=mapper.selectOne(queryWrapper);
        //判断 如果没有查询到用户就报异常
        if (Objects.isNull(user)){
            throw new RuntimeException("用户名错误");
        }

        //TODO 查询对应的权限信息

        //把数据封装成UserDetails
        return new LoginUser(user);
    }
}
