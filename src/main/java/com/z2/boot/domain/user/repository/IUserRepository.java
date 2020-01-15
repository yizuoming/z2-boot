package com.z2.boot.domain.user.repository;

import com.z2.boot.infrastructure.po.User;

/**
 * Created by yzm on 2019.
 */
public interface IUserRepository {

    public int create(User user);
}
