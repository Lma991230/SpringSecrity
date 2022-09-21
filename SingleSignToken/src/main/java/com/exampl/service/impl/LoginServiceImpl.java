package com.exampl.service.impl;

import com.exampl.domain.LoginUser;
import com.exampl.domain.ResponseResult;
import com.exampl.domain.User;
import com.exampl.filter.JwtAuthenticationTokenFilter;
import com.exampl.service.LoginService;
import com.exampl.utils.JwtUtil;
import com.exampl.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private RedisCache redisCache;


    @Override
    public ResponseResult login(User user) {
        UsernamePasswordAuthenticationToken authenticationToken=
                new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
        Authentication authenticate = manager.authenticate(authenticationToken);
        //如果认证没通过，返回对应的提示
        if (Objects.isNull(authenticate)){
            throw new RuntimeException("登陆失败");
        }
        //如果认证通过使用userid返回一个jwt
        LoginUser loginUser =(LoginUser)authenticate.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);
        Map<String,Object> map=new HashMap<>();
        map.put("token", jwt);
        //把完整的用户信息放到redis userid作为key value是user
        redisCache.setCacheObject("login"+userId, loginUser);

        return new ResponseResult(200, "登陆成功",map);
    }
}
