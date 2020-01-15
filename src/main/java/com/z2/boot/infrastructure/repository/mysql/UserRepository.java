package com.z2.boot.infrastructure.repository.mysql;

import com.z2.boot.domain.user.repository.IUserRepository;
import com.z2.boot.infrastructure.dao.UserDao;
import com.z2.boot.infrastructure.po.User;
import com.z2.boot.interfaces.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by yzm on 2019.
 */
@Repository("userRepository")
public class UserRepository implements IUserRepository {

    @Resource
    private UserDao userDao;

    @Override
    public int create(User user) {
        return userDao.create(user);
    }


}
