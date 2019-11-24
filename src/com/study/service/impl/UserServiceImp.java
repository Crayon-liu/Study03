package com.study.service.impl;

import com.study.dao.UserDao;
import com.study.dao.impl.UserDaoImp;
import com.study.domain.User;
import com.study.service.UserService;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.List;

public class UserServiceImp implements UserService {
    public UserDao userDao =new UserDaoImp();
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
