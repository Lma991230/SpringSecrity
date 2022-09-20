package com.exampl;

import com.exampl.domain.User;
import com.exampl.mapper.UserMapper;
import com.sun.javaws.IconUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class MapperTest {
    @Autowired
    private UserMapper mapper;
    @Test
    public  void test(){
        List<User> users = mapper.selectList(null);
        System.out.println(users);
    }

    @Test
    public void testPassword(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        String encode = bCryptPasswordEncoder.encode("1234");
        String encode1 = bCryptPasswordEncoder.encode("123456");
        System.out.println(encode1);
//        System.out.println(encode+"---"+encode1);
//        boolean b = bCryptPasswordEncoder.matches("1234", "$2a$10$gGyny3Hy0roE9CyEZMRT2egr6FDqucDOdu" +
//                "/duWSCv0K0iRlAxNxXG");
//        boolean b1 = bCryptPasswordEncoder.matches("12345", "$2a$10$gGyny3Hy0roE9CyEZMRT2egr6FDqucDOduduWSCv0K0iRlAxNxXG");
//        System.out.println(b);
//        System.out.println(b1);

    }
}
