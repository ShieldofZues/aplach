package com.hhera.dao;

import com.hhera.pojo.Cart;

public interface CartMapper {
    int deleteByPrimaryKey(Integer id);
sadasd
    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);
}