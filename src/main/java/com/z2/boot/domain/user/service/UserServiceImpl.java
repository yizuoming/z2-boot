package com.z2.boot.domain.user.service;

import com.z2.boot.application.UserService;
import com.z2.boot.domain.user.model.UserBo;
import com.z2.boot.infrastructure.po.User;
import com.z2.boot.infrastructure.repository.mysql.UserRepository;
import com.z2.boot.infrastructure.util.PojoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


/**
 * Create by yzm on @2019
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public int create(UserBo bo) throws Exception {
        if (null == bo) {
            throw new Exception("参数不能为空");
        }
        User user = PojoUtils.map(bo, User.class);
        user.setId(1L);
        user.setCreateId("1");
        user.setCreateName("admin");
        user.setCreateTime(new Date());
        userRepository.create(user);
        // TODO: insert log
        // TODO: send mail
        return 0;
    }
}
