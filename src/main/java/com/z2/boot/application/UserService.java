package com.z2.boot.application;

import com.z2.boot.domain.user.model.UserBo;

/**
 * Created by yzm on @2019
 */
public interface UserService {

    /**
     * 创建对象
     *
     * @param bo
     * @return
     */
    public int create(UserBo bo) throws Exception;

}
