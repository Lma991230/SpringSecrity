/**
 * @author: lma
 * @create: 2022/9/20
 * @Filename: LoginService
 */

package com.exampl.service;

import com.exampl.domain.ResponseResult;
import com.exampl.domain.User;
import org.springframework.stereotype.Service;


public interface LoginService {

    ResponseResult login(User user);
}
