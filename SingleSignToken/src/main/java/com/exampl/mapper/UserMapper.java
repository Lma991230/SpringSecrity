package com.exampl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.exampl.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
