package com.hhera.dao;

import com.hhera.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int checkUsername(String username);
//mybatis传递多个注解 用@param sql中直接用param中的参数
    User selectLogin(@Param("username") String username,@Param("password") String password);
}