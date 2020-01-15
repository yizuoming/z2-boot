package com.z2.boot.infrastructure.dao;

import com.z2.boot.infrastructure.po.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by yzm on 2019.
 */
@Mapper
public interface UserDao {

    public int create(User user);

}
